package com.codepath.todotask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    int position = 0;

    /**
     * Retrieves the Task original value and sets it to the Edit Task Text box.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String editTaskOriginalValue = getIntent().getStringExtra("editTaskOriginalValue");
        position = getIntent().getIntExtra("position", 0);
        EditText editTaskDetailText = (EditText) findViewById(R.id.editTaskDetail);
        editTaskDetailText.setText(editTaskOriginalValue);
        editTaskDetailText.setSelection(editTaskOriginalValue.length());
    }

    /**
     * This method handles the Save Edit Task button Click. Retrieves the updated
     * task detail and sets it to the Intent which will be transferred back to the
     * Main Activity.
     * @param v
     */
    public void onSaveEdits(View v) {
        EditText editDetail = (EditText) findViewById(R.id.editTaskDetail);
        String editedTask = editDetail.getText().toString();
        Intent data = new Intent();
        data.putExtra("editedTaskValue",editedTask);
        data.putExtra("position",position);
        setResult(RESULT_OK, data);
        finish();
    }


}
