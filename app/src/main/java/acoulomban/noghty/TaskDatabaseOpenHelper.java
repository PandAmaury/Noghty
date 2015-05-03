package acoulomban.noghty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by acoulomban on 03/05/15.
 */
public class TaskDatabaseOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TASKS_LIST";
    private static final String DATABASE_CREATE =
            "CREATE TABLE " + DATABASE_NAME + " (" +
                    "ID" + " INTEGER PRIMARY KEY, " +
                    "LABEL" + " TEXT, " +
                    "STATE" + " TEXT," +
                    "PARENT_TASK" + " INTEGER," +
                    "DESC" + " TEXT);";


    TaskDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }

    public void addTask(Task task) {
        ContentValues values = new ContentValues();

        //ID is chosen automatically
        values.put("LABEL", task.getLabel());
        values.put("STATE", task.getState());
        values.put("PARENT_TASK", task.getParentTask());
        values.put("DESC", task.getDescription());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DATABASE_NAME, null, values);
        db.close();
    }

    public Task findTasksByParent(int parentID) {
        //TODO : more than one result (look at moveToNext
        String query = "Select * FROM " + DATABASE_NAME + " WHERE " + "PARENT_TASK " + "= " + parentID + ";";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Task task = new Task();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            task.setId(Integer.parseInt(cursor.getString(0)));
            task.setLabel(cursor.getString(1));
            task.setState(cursor.getString(2));
            task.setParentTask(Integer.parseInt(cursor.getString(3)));
            task.setDescription(cursor.getString(4));

            cursor.close();

        } else {
            task = null;
        }

        db.close();
        return task;

    }


    public Task findTaskById(int id) {
        String query = "Select * FROM " + DATABASE_NAME + " WHERE " + "ID " + "= " + id + ";";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Task task = new Task();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            task.setId(Integer.parseInt(cursor.getString(0)));
            task.setLabel(cursor.getString(1));
            task.setState(cursor.getString(2));
            task.setParentTask(Integer.parseInt(cursor.getString(3)));
            task.setDescription(cursor.getString(4));

            cursor.close();

        } else {
            task = null;
        }

        db.close();
        return task;

    }

    public Task findTasksByLabel(String label) {
        //TODO : more than one result (look at moveToNext
        String query = "Select * FROM " + DATABASE_NAME + " WHERE " + "LABEL " + "LIKE " + "'" + label +"'" + ";";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Task task = new Task();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            task.setId(Integer.parseInt(cursor.getString(0)));
            task.setLabel(cursor.getString(1));
            task.setState(cursor.getString(2));
            task.setParentTask(Integer.parseInt(cursor.getString(3)));
            task.setDescription(cursor.getString(4));

            cursor.close();

        } else {
            task = null;
        }

        db.close();
        return task;

    }

    public boolean deleteTaskById(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(DATABASE_NAME, "ID" + "=" + Integer.toString(id), null ) > 0;
    }

}