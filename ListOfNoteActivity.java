package edu.ewubd.notegram.utilities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import edu.ewubd.notegram.R;
import edu.ewubd.notegram.dbhelpers.AppDatabase;
import edu.ewubd.notegram.entities.NoteEntity;

public class ListOfNoteActivity extends AppCompatActivity {

    public Context context;
    public AppDatabase db;
    public ListView NoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_note);
      //  Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        context = this;

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, edu.ewubd.notegram.utilities.ManageNoteActivity.class);
                startActivity(intent);
            }
        });

        LoadNotes();
    }

    public void LoadNotes(){
        NoteList = (ListView) findViewById(R.id.NoteList);
        db = Room.databaseBuilder(this,
                AppDatabase.class, "NotesDB").build();

        new AgentAsyncTask().execute();
    }

    private class AgentAsyncTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... params) {
            List<NoteEntity> noteEntities = new ArrayList<>();
            noteEntities = db.noteDAO().GetAll();

            NoteListAdapter adapter = new NoteListAdapter(context, noteEntities);

            NoteList.setAdapter(adapter);

            return 0;
        }

        @Override
        protected void onPostExecute(Integer agentsCount) {

        }
    }
}
