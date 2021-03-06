package edu.aku.hassannaqvi.uenhouseholdrapidsurvey.ui.sections;

import static edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp.sharedPref;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.R;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.database.DatabaseHelper;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.databinding.ActivitySectionI2Binding;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.FamilyMembers;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.ui.EndingActivity;

public class SectionI2Activity extends AppCompatActivity {

    private static final String TAG = "SectionI2Activity";
    ActivitySectionI2Binding bi;
    private DatabaseHelper db;
    private ArrayList<String> respNames, respLineNo, respFmUIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(sharedPref.getString("lang", "0").equals("2") ? R.style.AppThemeSindhi : sharedPref.getString("lang", "0").equals("1") ? R.style.AppThemeUrdu : R.style.AppThemeEnglish1);


        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i2);
        bi.setChildARI(MainApp.childARI);
        setSupportActionBar(bi.toolbar);
        setTitle(R.string.sectioni2acuterespiratoryinfectionari_mainheading);
        db = MainApp.appInfo.dbHelper;
        //   bi.age.setText(getIntent().getStringExtra("age"));
        populateSpinner();
    }

    private void populateSpinner() {

        // Populate Respondents
        List<FamilyMembers> respList = new ArrayList<>();
        try {
            respList = db.getAllRespondents();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(Familymembers): " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        respNames = new ArrayList<>();
        respLineNo = new ArrayList<>();
        respFmUIDs = new ArrayList<>();

        respNames.add("...");
        respLineNo.add("");
        respFmUIDs.add("");

        int selectedResp = 0;
        int counter = 0;

        for (FamilyMembers fm : respList) {

            respNames.add(fm.getD102());
            respLineNo.add(fm.getD101());
            respFmUIDs.add(fm.getUid());

            if (MainApp.childARI.getI202cno().equals(fm.getD101())) {
                selectedResp = counter;
            }
            counter++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SectionI2Activity.this,
                R.layout.custom_spinner, respNames);

        bi.i202as.setAdapter(adapter);
        bi.i202as.setSelection(selectedResp);


        bi.i202as.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // for EditMode auto selection
                if (MainApp.childARI.getI202cno().equals(respLineNo.get(bi.i202as.getSelectedItemPosition()))) {
                    return;
                } else {

                    //   if(position == 0) return;
                    bi.i202c.setText("");
                    bi.i202cno.setText("");
                    MainApp.childARI.setRespFmuid(respFmUIDs.get(bi.i202as.getSelectedItemPosition()));
                    MainApp.childARI.setI202cno(respLineNo.get(bi.i202as.getSelectedItemPosition()));
                    MainApp.childARI.setI202c(respNames.get(bi.i202as.getSelectedItemPosition()));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private boolean updateDB() {
        if (MainApp.superuser) return true;

        int updcount = 0;
        try {
            updcount = db.updatesChildARIColumn(TableContracts.ChildARITable.COLUMN_SI2, MainApp.childARI.sI2toString());
        } catch (JSONException e) {
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionM1Activity.class));
        } else {
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }

    private void saveDraft() {
    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }

    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.i202b02.isChecked() && bi.i202c.getText().toString().isEmpty()) {
            return Validator.emptyCustomTextBox(this, bi.i202c, "Select Respondent");
        }

        return true;
    }


    @Override
    public void onBackPressed() {
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
    }
}