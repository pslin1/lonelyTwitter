package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button clearButton = (Button) findViewById(R.id.clear);

		try {
			Tweet tweet = new NormalTweet("First tweet");
			tweet.setMessage("ghsdjk");
			importantTweet importantTweet = new importantTweet("very important"); //importantTweet is a subclass of Tweet
			//importantTweet.getDate();
			NormalTweet normalTweet = new NormalTweet("im normal");
			importantTweet.getDate();

			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
			arrayList.add(tweet);
			arrayList.add(importantTweet);
			arrayList.add(normalTweet);

//			Mood happy = new mood1();
//			Mood sad = new mood2();
//
//			tweet.moodList.add(happy);
//			importantTweet.moodList.add(sad);
//			normalTweet.moodList.add(happy);
//			normalTweet.moodList.add(sad);




		} catch (TweetTooLongException e) {
			e.printStackTrace();
		}

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet tweet = null;

				try {
					tweet = new NormalTweet(text);
				} catch (TweetTooLongException e) {
					e.printStackTrace();
				}

				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

                saveInFile();
//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();

				adapter.notifyDataSetChanged();
				deleteFile(FILENAME);
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

        loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);



	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

//            new TypeToken<ArrayList<Tweet>>().getType());
            //Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            //2017-01-24 18:19
            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
            tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
            tweetList = new ArrayList<Tweet>();
			// TODO Auto-generated catch block

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}

	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO: Handle the Exception later
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO: Handle the Exception Later
			throw new RuntimeException();
		}
	}
}