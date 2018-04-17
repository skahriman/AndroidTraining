package com.sefakkahriman.employeecontentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sefakkahriman.employeecontentprovider.data.EmployeeFactory;
import com.sefakkahriman.employeecontentprovider.model.Employee;
import com.sefakkahriman.employeecontentprovider.model.EmployeeContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeButtonBackgroundState();
    }

    private void changeButtonBackgroundState() {
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[] {android.R.attr.state_pressed},new ColorDrawable(Color.RED));
        states.addState(new int[] {android.R.attr.state_focused},new ColorDrawable(Color.GREEN));
        states.addState(new int[] { },new ColorDrawable(Color.YELLOW));
        findViewById(R.id.button2).setBackground(states);
    }

    public void saveDataToDb(View view) {

        for (Employee employee : EmployeeFactory.createLegendGroups()) {
            ContentValues values = new ContentValues();
            values.put(EmployeeContract.COLUMN_NAME, employee.getName());
            values.put(EmployeeContract.COLUMN_PHONE, employee.getPhoneNumber());

            Uri newUri = getContentResolver().insert(EmployeeContract.EMPLOYEE_URI, values);
        }

    }

    public void count(View view) {
        System.out.println(123);
        Cursor cursor = getContentResolver().query(EmployeeContract.EMPLOYEE_URI, null, null, null, null);
        Toast.makeText(this, "count in Content Provider : " + cursor.getCount(), Toast.LENGTH_SHORT).show();
    }
}
