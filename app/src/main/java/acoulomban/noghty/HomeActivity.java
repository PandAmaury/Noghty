package acoulomban.noghty;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);

        Context context = getApplicationContext();

        TaskDatabaseOpenHelper TaskDatabaseOH = new TaskDatabaseOpenHelper(context);

        Task rootTask = new Task("label3", "state1", 0, "desc1");
        TaskDatabaseOH.addTask(rootTask);

        Task tesTask;
        tesTask = TaskDatabaseOH.findTasksByLabel("label3");

        Toast toast = Toast.makeText(context, Integer.toString(tesTask.getId()), Toast.LENGTH_LONG);
        toast.show();

        TaskDatabaseOH.deleteTaskById(tesTask.getId());





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
        //TODO
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
        //TODO
    }
}
