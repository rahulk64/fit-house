package com.jagre.godark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class activity_leaderboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
	ListView leaderboard;

	String names [] = {"John", "Abby", "Rahul", "Grant", "Emily"};
	double scores [] = {42.0, 42.0, 42.0, 42.0, 42.0};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaderboard);
		Toolbar toolbar = findViewById(R.id.toolbar);
//		setSupportActionBar(toolbar);
//		DrawerLayout drawer = findViewById(R.id.drawer_layout);
//		NavigationView navigationView = findViewById(R.id.nav_view);
//		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//		drawer.addDrawerListener(toggle);
//		toggle.syncState();
//		navigationView.setNavigationItemSelectedListener(this);


		leaderboard = findViewById(R.id.leaderboard_list);


		LeaderboardAdapter adapter = new LeaderboardAdapter(this, names, scores);
		leaderboard.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}


	class LeaderboardPosition implements Comparable<LeaderboardPosition>
	{
		String name;
		double score;

		LeaderboardPosition (double score, String name)
		{
			this.name = name;
			this.score = score;
		}

		@Override
		public int compareTo (LeaderboardPosition other)
		{
			return new Double(other.score).compareTo(new Double (this.score));
		}
	}

	class LeaderboardAdapter extends ArrayAdapter<String>
	{
		Context context;
		ArrayList<LeaderboardPosition> leaderboard;

		LeaderboardAdapter (Context c, String name [], double score [])
		{
			super (c, R.layout.leaderboard_row, name);
			leaderboard = new ArrayList<LeaderboardPosition>();
			for (int i = 0; i < name.length; i++)
			{
				leaderboard.add(new LeaderboardPosition(score [i], name [i]));
			}
//			leaderboard.add (new LeaderboardPosition(DataEntryActivity.myScore, "Me"));


			Collections.sort(leaderboard);

			this.context = c;
		}

		@NonNull
		@Override
		public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent)
		{
			LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = layoutInflater.inflate(R.layout.leaderboard_row, parent, false);

			TextView rankView = row.findViewById(R.id.rank);
			TextView nameView = row.findViewById(R.id.name);
			TextView scoreView = row.findViewById(R.id.score);

			rankView.setText(""+(position+1));
			nameView.setText(leaderboard.get(position).name);
			scoreView.setText("" + leaderboard.get(position).score);

			return row;
		}
	}

	@Override
	public void onBackPressed()
	{
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START))
		{
			drawer.closeDrawer(GravityCompat.START);
		}
		else
		{
			super.onBackPressed();
		}
	}

	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_home) {
			// Handle the camera action
		} else if (id == R.id.nav_gallery) {

		} else if (id == R.id.nav_slideshow) {

		} else if (id == R.id.nav_tools) {

		} else if (id == R.id.nav_share) {

		} else if (id == R.id.nav_send) {

		}

		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
