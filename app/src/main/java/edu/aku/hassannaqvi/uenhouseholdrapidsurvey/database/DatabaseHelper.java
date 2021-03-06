package edu.aku.hassannaqvi.uenhouseholdrapidsurvey.database;


import static edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp.IBAHC;
import static edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp.child;
import static edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp.childARI;
import static edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.UserAuth.checkPassword;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.ChildARITable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.ChildDIATable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.ChildTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.ClusterTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.EntryLogTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.FamilyMembersTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.MaternalMortalityTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.MwraTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.PregnancyDetailsTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.PregnancyMasterTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.RandomHHTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.UsersTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.VersionTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.Child;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.ChildARI;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.ChildDIA;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.Clusters;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.EntryLog;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.FamilyMembers;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.Form;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.MWRA;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.MaternalMortality;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.PregnancyDetails;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.PregnancyMaster;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.RandomHH;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.Users;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.VersionApp;
/*
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models.Villages;
*/



/*import edu.aku.hassannaqvi.naunehal.models.Immunization;*/

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 01/07/21
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = PROJECT_NAME + ".db";
    public static final String DATABASE_COPY = PROJECT_NAME + "_copy.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_PASSWORD = IBAHC;
    private final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTable.SQL_CREATE_USERS);
        db.execSQL(CreateTable.SQL_CREATE_CLUSTERS);
        db.execSQL(CreateTable.SQL_CREATE_RANDOM_HH);

        db.execSQL(CreateTable.SQL_CREATE_FORMS);
        db.execSQL(CreateTable.SQL_CREATE_ENTRYLOGS);
        db.execSQL(CreateTable.SQL_CREATE_MWRA);
        db.execSQL(CreateTable.SQL_CREATE_PREGNANCY_DETAILS);
        db.execSQL(CreateTable.SQL_CREATE_PREGNANCY_MASTER);
        db.execSQL(CreateTable.SQL_CREATE_MATERNAL_MORTIALITY);
        db.execSQL(CreateTable.SQL_CREATE_CHILD);
        db.execSQL(CreateTable.SQL_CREATE_CHILD_DIA);
        db.execSQL(CreateTable.SQL_CREATE_CHILD_ARI);

        db.execSQL(CreateTable.SQL_CREATE_FAMILYMEMBERS);
        db.execSQL(CreateTable.SQL_CREATE_VERSIONAPP);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
            case 2:
        }
    }


    //ADDITION in DB
    public Long addForm(Form form) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(FormsTable.COLUMN_UID, form.getUid());
        values.put(FormsTable.COLUMN_PSU_CODE, form.getPsuCode());
        values.put(FormsTable.COLUMN_HHID, form.getHhid());
        values.put(FormsTable.COLUMN_SNO, form.getSno());
        values.put(FormsTable.COLUMN_USERNAME, form.getUserName());
        values.put(FormsTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(FormsTable.COLUMN_SA, form.sAtoString());
        values.put(FormsTable.COLUMN_SM, form.sMtoString());
        values.put(FormsTable.COLUMN_SN, form.sNtoString());
        values.put(FormsTable.COLUMN_SO, form.sOtoString());
        values.put(FormsTable.COLUMN_SE2, form.sE2toString());
        values.put(FormsTable.COLUMN_ISTATUS, form.getiStatus());
        values.put(FormsTable.COLUMN_DEVICETAGID, form.getDeviceTag());
/*
        values.put(FormsTable.COLUMN_ENTRY_TYPE, form.getEntryType());
*/
        values.put(FormsTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(FormsTable.COLUMN_APPVERSION, form.getAppver());
        values.put(FormsTable.COLUMN_SYNCED, form.getSynced());
        values.put(FormsTable.COLUMN_SYNC_DATE, form.getSyncDate());

        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addEntryLog(EntryLog entryLog) throws SQLiteException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_PROJECT_NAME, entryLog.getProjectName());
        values.put(EntryLogTable.COLUMN_UUID, entryLog.getUuid());
        values.put(EntryLogTable.COLUMN_PSU_CODE, entryLog.getPsuCode());
        values.put(EntryLogTable.COLUMN_HHID, entryLog.getHhid());
        values.put(EntryLogTable.COLUMN_USERNAME, entryLog.getUserName());
        values.put(EntryLogTable.COLUMN_SYSDATE, entryLog.getSysDate());
        values.put(EntryLogTable.COLUMN_ISTATUS, entryLog.getiStatus());
        values.put(EntryLogTable.COLUMN_ISTATUS96x, entryLog.getiStatus96x());
        values.put(EntryLogTable.COLUMN_ENTRY_TYPE, entryLog.getEntryType());
        values.put(EntryLogTable.COLUMN_ENTRY_DATE, entryLog.getEntryDate());
        values.put(EntryLogTable.COLUMN_DEVICEID, entryLog.getDeviceId());
        values.put(EntryLogTable.COLUMN_SYNCED, entryLog.getSynced());
        values.put(EntryLogTable.COLUMN_SYNC_DATE, entryLog.getSyncDate());
        values.put(EntryLogTable.COLUMN_APPVERSION, entryLog.getAppver());

        long newRowId;
        newRowId = db.insertOrThrow(
                EntryLogTable.TABLE_NAME,
                EntryLogTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMWRA(MWRA mwra) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(MwraTable.COLUMN_PROJECT_NAME, mwra.getProjectName());
        values.put(MwraTable.COLUMN_UID, mwra.getUid());
        values.put(MwraTable.COLUMN_UUID, mwra.getUuid());
        values.put(MwraTable.COLUMN_FMUID, mwra.getFmuid());
        //  values.put(MwraTable.COLUMN_MUID, mwra.getMuid());
        values.put(MwraTable.COLUMN_SNO, mwra.getSno());
        values.put(MwraTable.COLUMN_PSU_CODE, mwra.getpsuCode());
        values.put(MwraTable.COLUMN_HHID, mwra.getHhid());
        values.put(MwraTable.COLUMN_USERNAME, mwra.getUserName());
        values.put(MwraTable.COLUMN_SYSDATE, mwra.getSysDate());
        values.put(MwraTable.COLUMN_SF, mwra.sFtoString());
        values.put(MwraTable.COLUMN_SG, mwra.sGtoString());
        values.put(MwraTable.COLUMN_SH1, mwra.sH1toString());
        values.put(MwraTable.COLUMN_SH2, mwra.sH2toString());
        values.put(MwraTable.COLUMN_SK, mwra.sKtoString());
        values.put(MwraTable.COLUMN_SL, mwra.sLtoString());
        values.put(MwraTable.COLUMN_UN, mwra.uNtoString());
        values.put(MwraTable.COLUMN_ISTATUS, mwra.getiStatus());
        values.put(MwraTable.COLUMN_DEVICETAGID, mwra.getDeviceTag());
        values.put(MwraTable.COLUMN_DEVICEID, mwra.getDeviceId());
        values.put(MwraTable.COLUMN_APPVERSION, mwra.getAppver());
        values.put(MwraTable.COLUMN_SYNCED, mwra.getSynced());
        values.put(MwraTable.COLUMN_SYNC_DATE, mwra.getSyncDate());

        long newRowId;
        newRowId = db.insertOrThrow(
                MwraTable.TABLE_NAME,
                MwraTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChild(Child child) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(ChildARITable.COLUMN_PROJECT_NAME, child.getProjectName());
        values.put(ChildTable.COLUMN_UID, child.getUid());
        values.put(ChildTable.COLUMN_UUID, child.getUuid());
        values.put(ChildTable.COLUMN_FMUID, child.getFmuid());
        values.put(ChildTable.COLUMN_MUID, child.getMuid());
        values.put(ChildTable.COLUMN_SNO, child.getSno());
        values.put(ChildTable.COLUMN_PSU_CODE, child.getpsuCode());
        values.put(ChildTable.COLUMN_HHID, child.getHhid());
        values.put(ChildTable.COLUMN_USERNAME, child.getUserName());
        values.put(ChildTable.COLUMN_SYSDATE, child.getSysDate());
        values.put(ChildTable.COLUMN_SIM, child.sIMtoString());
        values.put(ChildTable.COLUMN_ISTATUS, child.getiStatus());
        values.put(ChildTable.COLUMN_DEVICETAGID, child.getDeviceTag());
        values.put(ChildTable.COLUMN_DEVICEID, child.getDeviceId());
        values.put(ChildTable.COLUMN_APPVERSION, child.getAppver());
        values.put(ChildTable.COLUMN_SYNCED, child.getSynced());
        values.put(ChildTable.COLUMN_SYNC_DATE, child.getSyncDate());
        long newRowId;
        newRowId = db.insert(
                ChildTable.TABLE_NAME,
                ChildTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChildDIA(ChildDIA childDIA) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(ChildDIATable.COLUMN_PROJECT_NAME, childDIA.getProjectName());
        values.put(ChildDIATable.COLUMN_UID, childDIA.getUid());
        values.put(ChildDIATable.COLUMN_UUID, childDIA.getUuid());
        values.put(ChildDIATable.COLUMN_FMUID, childDIA.getFmuid());
        values.put(ChildDIATable.COLUMN_MUID, childDIA.getMuid());
        values.put(ChildDIATable.COLUMN_SNO, childDIA.getSno());
        values.put(ChildDIATable.COLUMN_PSU_CODE, childDIA.getpsuCode());
        values.put(ChildDIATable.COLUMN_HHID, childDIA.getHhid());
        values.put(ChildDIATable.COLUMN_USERNAME, childDIA.getUserName());
        values.put(ChildDIATable.COLUMN_SYSDATE, childDIA.getSysDate());
        values.put(ChildDIATable.COLUMN_SI1, childDIA.sI1toString());
        values.put(ChildDIATable.COLUMN_ISTATUS, childDIA.getiStatus());
        values.put(ChildDIATable.COLUMN_DEVICETAGID, childDIA.getDeviceTag());
        values.put(ChildDIATable.COLUMN_DEVICEID, childDIA.getDeviceId());
        values.put(ChildDIATable.COLUMN_APPVERSION, childDIA.getAppver());
        values.put(ChildDIATable.COLUMN_SYNCED, childDIA.getSynced());
        values.put(ChildDIATable.COLUMN_SYNC_DATE, childDIA.getSyncDate());
        long newRowId;
        newRowId = db.insert(
                ChildDIATable.TABLE_NAME,
                ChildDIATable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addChildARI(ChildARI childARI) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(ChildARITable.COLUMN_PROJECT_NAME, childARI.getProjectName());
        values.put(ChildARITable.COLUMN_UID, childARI.getUid());
        values.put(ChildARITable.COLUMN_UUID, childARI.getUuid());
        values.put(ChildARITable.COLUMN_FMUID, childARI.getFmuid());
        values.put(ChildARITable.COLUMN_MUID, childARI.getMuid());
        values.put(ChildARITable.COLUMN_SNO, childARI.getSno());
        values.put(ChildARITable.COLUMN_PSU_CODE, childARI.getpsuCode());
        values.put(ChildARITable.COLUMN_HHID, childARI.getHhid());
        values.put(ChildARITable.COLUMN_USERNAME, childARI.getUserName());
        values.put(ChildARITable.COLUMN_SYSDATE, childARI.getSysDate());
        values.put(ChildARITable.COLUMN_SI2, childARI.sI2toString());
        values.put(ChildARITable.COLUMN_ISTATUS, childARI.getiStatus());
        values.put(ChildARITable.COLUMN_DEVICETAGID, childARI.getDeviceTag());
        values.put(ChildARITable.COLUMN_DEVICEID, childARI.getDeviceId());
        values.put(ChildARITable.COLUMN_APPVERSION, childARI.getAppver());
        values.put(ChildARITable.COLUMN_SYNCED, childARI.getSynced());
        values.put(ChildARITable.COLUMN_SYNC_DATE, childARI.getSyncDate());
        long newRowId;
        newRowId = db.insert(
                ChildARITable.TABLE_NAME,
                ChildARITable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addPregnancyMaster(PregnancyMaster pregM) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(PregnancyMasterTable.COLUMN_PROJECT_NAME, pregM.getProjectName());
        values.put(PregnancyMasterTable.COLUMN_UID, pregM.getUid());
        values.put(PregnancyMasterTable.COLUMN_UUID, pregM.getUuid());
        values.put(PregnancyMasterTable.COLUMN_FMUID, pregM.getFmuid());
        values.put(PregnancyMasterTable.COLUMN_PSU_CODE, pregM.getClusterCode());
        values.put(PregnancyMasterTable.COLUMN_HHID, pregM.getHhid());
        values.put(PregnancyMasterTable.COLUMN_SNO, pregM.getSno());
        values.put(PregnancyMasterTable.COLUMN_M_NAME, pregM.getMName());
        values.put(PregnancyMasterTable.COLUMN_USERNAME, pregM.getUserName());
        values.put(PregnancyMasterTable.COLUMN_SYSDATE, pregM.getSysDate());
        values.put(PregnancyMasterTable.COLUMN_SE1, pregM.sE1toString());
        values.put(PregnancyMasterTable.COLUMN_ISTATUS, pregM.getiStatus());
        values.put(PregnancyMasterTable.COLUMN_DEVICETAGID, pregM.getDeviceTag());
        values.put(PregnancyMasterTable.COLUMN_DEVICEID, pregM.getDeviceId());
        values.put(PregnancyMasterTable.COLUMN_APPVERSION, pregM.getAppver());
        values.put(PregnancyMasterTable.COLUMN_SYNCED, pregM.getSynced());
        values.put(PregnancyMasterTable.COLUMN_SYNC_DATE, pregM.getSyncDate());

        long newRowId;
        newRowId = db.insertOrThrow(
                PregnancyMasterTable.TABLE_NAME,
                PregnancyMasterTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addPregnancyDetails(PregnancyDetails pregD) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(PregnancyDetailsTable.COLUMN_PROJECT_NAME, pregD.getProjectName());
        values.put(PregnancyDetailsTable.COLUMN_UID, pregD.getUid());
        values.put(PregnancyDetailsTable.COLUMN_UUID, pregD.getUuid());
        values.put(PregnancyDetailsTable.COLUMN_FMUID, pregD.getFmuid());
        values.put(PregnancyDetailsTable.COLUMN_PSU_CODE, pregD.getPsuCode());
        values.put(PregnancyDetailsTable.COLUMN_HHID, pregD.getHhid());
        values.put(PregnancyDetailsTable.COLUMN_PSNO, pregD.getPSno());
        values.put(PregnancyDetailsTable.COLUMN_MSNO, pregD.getMsno());
        values.put(PregnancyDetailsTable.COLUMN_M_NAME, pregD.getMName());
        values.put(PregnancyDetailsTable.COLUMN_USERNAME, pregD.getUserName());
        values.put(PregnancyDetailsTable.COLUMN_SYSDATE, pregD.getSysDate());
        values.put(PregnancyDetailsTable.COLUMN_SE1, pregD.sE1toString());
        values.put(PregnancyDetailsTable.COLUMN_ISTATUS, pregD.getiStatus());
        values.put(PregnancyDetailsTable.COLUMN_DEVICETAGID, pregD.getDeviceTag());
        values.put(PregnancyDetailsTable.COLUMN_DEVICEID, pregD.getDeviceId());
        values.put(PregnancyDetailsTable.COLUMN_APPVERSION, pregD.getAppver());
        values.put(PregnancyDetailsTable.COLUMN_SYNCED, pregD.getSynced());
        values.put(PregnancyDetailsTable.COLUMN_SYNC_DATE, pregD.getSyncDate());

        long newRowId;
        newRowId = db.insert(
                PregnancyDetailsTable.TABLE_NAME,
                PregnancyDetailsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addMortality(MaternalMortality mortality) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(MaternalMortalityTable.COLUMN_PROJECT_NAME, mortality.getProjectName());
        values.put(MaternalMortalityTable.COLUMN_UID, mortality.getUid());
        values.put(MaternalMortalityTable.COLUMN_UUID, mortality.getUuid());
        values.put(MaternalMortalityTable.COLUMN_PSU_CODE, mortality.getpsuCode());
        values.put(MaternalMortalityTable.COLUMN_HHID, mortality.getHhid());
        values.put(MaternalMortalityTable.COLUMN_SNO, mortality.getSno());
        values.put(MaternalMortalityTable.COLUMN_USERNAME, mortality.getUserName());
        values.put(MaternalMortalityTable.COLUMN_SYSDATE, mortality.getSysDate());
        values.put(MaternalMortalityTable.COLUMN_ISTATUS, mortality.getiStatus());
        values.put(MaternalMortalityTable.COLUMN_DEVICETAGID, mortality.getDeviceTag());
        values.put(MaternalMortalityTable.COLUMN_DEVICEID, mortality.getDeviceId());
        values.put(MaternalMortalityTable.COLUMN_APPVERSION, mortality.getAppver());
        values.put(MaternalMortalityTable.COLUMN_SYNCED, mortality.getSynced());
        values.put(MaternalMortalityTable.COLUMN_SYNC_DATE, mortality.getSyncDate());

        values.put(MaternalMortalityTable.COLUMN_SE2, mortality.sE2toString());

        long newRowId;
        newRowId = db.insert(
                MaternalMortalityTable.TABLE_NAME,
                MaternalMortalityTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addHHMembers(FamilyMembers members) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(FamilyMembersTable.COLUMN_PROJECT_NAME, members.getProjectName());
        values.put(FamilyMembersTable.COLUMN_UID, members.getUid());
        values.put(FamilyMembersTable.COLUMN_UUID, members.getUuid());
        values.put(FamilyMembersTable.COLUMN_PSU_CODE, members.getpsuCode());
        values.put(FamilyMembersTable.COLUMN_HHID, members.getHhid());
        values.put(FamilyMembersTable.COLUMN_SNO, members.getSno());
        values.put(FamilyMembersTable.COLUMN_AGE_MONTHS, members.getAgeInMonths());
        values.put(FamilyMembersTable.COLUMN_MUID, members.getMuid());
        values.put(FamilyMembersTable.COLUMN_USERNAME, members.getUserName());
        values.put(FamilyMembersTable.COLUMN_SYSDATE, members.getSysDate());
        values.put(FamilyMembersTable.COLUMN_SD, members.sDtoString());
        values.put(FamilyMembersTable.COLUMN_ISTATUS, members.getiStatus());
        values.put(FamilyMembersTable.COLUMN_DEVICETAGID, members.getDeviceTag());
        values.put(FamilyMembersTable.COLUMN_DEVICEID, members.getDeviceId());
        values.put(FamilyMembersTable.COLUMN_APPVERSION, members.getAppver());


        long newRowId;
        newRowId = db.insert(
                FamilyMembersTable.TABLE_NAME,
                FamilyMembersTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addFamilyMembers(FamilyMembers members) throws JSONException {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FamilyMembersTable.COLUMN_PROJECT_NAME, members.getProjectName());
        values.put(FamilyMembersTable.COLUMN_UID, members.getUid());
        values.put(FamilyMembersTable.COLUMN_UUID, members.getUuid());
        values.put(FamilyMembersTable.COLUMN_PSU_CODE, members.getpsuCode());
        values.put(FamilyMembersTable.COLUMN_HHID, members.getHhid());
        values.put(FamilyMembersTable.COLUMN_AGE_MONTHS, members.getAgeInMonths());
        values.put(FamilyMembersTable.COLUMN_MUID, members.getMuid());
        values.put(FamilyMembersTable.COLUMN_MOTHER_PRESENT, members.getMotherPresent());
        values.put(FamilyMembersTable.COLUMN_USERNAME, members.getUserName());
        values.put(FamilyMembersTable.COLUMN_SYSDATE, members.getSysDate());
        values.put(FamilyMembersTable.COLUMN_INDEXED, members.getIndexed());
        values.put(FamilyMembersTable.COLUMN_SD, members.sDtoString());
        values.put(FamilyMembersTable.COLUMN_ISTATUS, members.getiStatus());
        values.put(FamilyMembersTable.COLUMN_DEVICETAGID, members.getDeviceTag());
        values.put(FamilyMembersTable.COLUMN_DEVICEID, members.getDeviceId());
        values.put(FamilyMembersTable.COLUMN_APPVERSION, members.getAppver());
        values.put(FamilyMembersTable.COLUMN_SYNCED, members.getSynced());
        values.put(FamilyMembersTable.COLUMN_SYNC_DATE, members.getSyncDate());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FamilyMembersTable.TABLE_NAME,
                FamilyMembersTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //UPDATE in DB
    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesEntryLogColumn(String column, String value, String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = EntryLogTable._ID + " =? ";
        String[] selectionArgs = {id};

        return db.update(EntryLogTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    public int updatesChildColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ChildTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(child.getId())};

        return db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesChildDIAColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ChildDIATable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.childDIA.getId())};

        return db.update(ChildDIATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesChildARIColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ChildARITable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(childARI.getId())};

        return db.update(ChildARITable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesMWRAColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = MwraTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.mwra.getId())};

        return db.update(MwraTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesMemberColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FamilyMembersTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.familyMember.getId())};

        return db.update(FamilyMembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesPregnancyMasterColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = PregnancyMasterTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.pregM.getId())};

        return db.update(PregnancyMasterTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesPregnancyDetailsColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = PregnancyDetailsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.pregD.getId())};

        return db.update(PregnancyDetailsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesMortalityColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = MaternalMortalityTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.mortality.getId())};

        return db.update(MaternalMortalityTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.form.getiStatus());

        // Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //Functions that dealing with table data
    public boolean doLogin(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalArgumentException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = UsersTable.COLUMN_USERNAME + "=? ";
        String[] whereArgs = {username};
        String groupBy = null;
        String having = null;
        String orderBy = UsersTable.COLUMN_ID + " ASC";

        Users loggedInUser = new Users();
        c = db.query(
                UsersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            loggedInUser = new Users().hydrate(c);

        }

        c.close();

        db.close();

        if (checkPassword(password, loggedInUser.getPassword())) {
            MainApp.user = loggedInUser;
            MainApp.selectedDistrict = loggedInUser.getDist_id();
            return c.getCount() > 0;
        } else {
            return false;
        }
    }


/*    public String validatePassword(String password, String encodedPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException {


        byte[] cipherPassword = Base64.decode(encodedPassword, Base64.NO_WRAP);
        byte[] salt = Arrays.copyOfRange(cipherPassword, 0, 16);
        byte[] hash = Arrays.copyOfRange(cipherPassword, 16, cipherPassword.length);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(salt);
        byte[] byteData = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        Log.d("TAG", "computeHash: " + sb);
        return sb.toString();
    }


    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }*/

    public ArrayList<Form> getFormsByDate(String sysdate) {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form forms = new Form();
                forms.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                forms.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                forms.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                forms.setUserName(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_USERNAME)));
                allForms.add(forms);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    // istatus examples: (1) or (1,9) or (1,3,5)
    public Form getFormByAssessNo(String uid, String istatus) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_UID + "=? AND " +
                FormsTable.COLUMN_ISTATUS + " in " + istatus;

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form allFC = null;
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allFC = new Form().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public ArrayList<Cursor> getDatabaseManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    /*public int updateTemp(String assessNo, String temp) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_TSF305, temp);
        values.put(FormsTable.COLUMN_SYSDATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()) + "-Updated");
        values.put(FormsTable.COLUMN_ISTATUS, "1");
        values.put(FormsTable.COLUMN_SYNCED, (byte[]) null);

        String selection = FormsTable.COLUMN_ASSESMENT_NO + " =? AND " + FormsTable.COLUMN_ISTATUS + " =? ";
        // String selection = FormsTable.COLUMN_ASSESMENT_NO + " =? ";
        String[] selectionArgs = {assessNo, "9"};
        // String[] selectionArgs = {assessNo};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }*/


    public int syncVersionApp(JSONObject VersionList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(VersionTable.TABLE_NAME, null, null);
        long count = 0;
        JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionTable.COLUMN_VERSION_PATH)).getJSONObject(0);
        VersionApp Vc = new VersionApp();
        Vc.sync(jsonObjectCC);

        ContentValues values = new ContentValues();

        values.put(VersionTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;


            db.close();


        return (int) count;
    }

    public int syncUser(JSONArray userList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        for (int i = 0; i < userList.length(); i++) {

            JSONObject jsonObjectUser = userList.getJSONObject(i);

            Users user = new Users();
            user.sync(jsonObjectUser);
            ContentValues values = new ContentValues();

            values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
            values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
            values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
            values.put(UsersTable.COLUMN_ENABLED, user.getEnabled());
            values.put(UsersTable.COLUMN_ISNEW_USER, user.getNewUser());
            values.put(UsersTable.COLUMN_PWD_EXPIRY, user.getPwdExpiry());
            values.put(UsersTable.COLUMN_DESIGNATION, user.getDesignation());
            values.put(UsersTable.COLUMN_DIST_ID, user.getDist_id());
            long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
            if (rowID != -1) insertCount++;
        }


        db.close();

        db.close();

        return insertCount;
    }

   /* public int syncVillages(JSONArray clusterList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(VillagesTable.TABLE_NAME, null, null);
        int insertCount = 0;
        for (int i = 0; i < clusterList.length(); i++) {

            JSONObject json = clusterList.getJSONObject(i);

            Villages villages = new Villages();
            villages.sync(json);
            ContentValues values = new ContentValues();

                values.put(VillagesTable.COLUMN_COUNTRY, villages.getCountry());
                values.put(VillagesTable.COLUMN_CCODE, villages.getCcode());
                values.put(VillagesTable.COLUMN_PROVINCE, villages.getProvince());
                values.put(VillagesTable.COLUMN_PROVCODE, villages.getProvcode());
                values.put(VillagesTable.COLUMN_DISTRICT_NAME, villages.getDistrictName());
                values.put(VillagesTable.COLUMN_DCODE, villages.getDcode());
                values.put(VillagesTable.COLUMN_VILLAGE, villages.getVillage());
                values.put(VillagesTable.COLUMN_VCODE, villages.getVcode());
                values.put(VillagesTable.COLUMN_PSUCODE, villages.getPsucode());


                long rowID = db.insert(VillagesTable.TABLE_NAME, null, values);
            if (rowID != -1) insertCount++;
        }


        db.close();

        db.close();

        return insertCount;
    }*/

    public int syncClusters(JSONArray clusterList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(ClusterTable.TABLE_NAME, null, null);
        int insertCount = 0;
        for (int i = 0; i < clusterList.length(); i++) {

            JSONObject json = clusterList.getJSONObject(i);

            Clusters clusters = new Clusters();
            clusters.sync(json);
            ContentValues values = new ContentValues();

            values.put(ClusterTable.COLUMN_CLUSTER_NO, clusters.getClusterNo());
            values.put(ClusterTable.COLUMN_GEOAREA, clusters.getGeoarea());
            values.put(ClusterTable.COLUMN_DIST_ID, clusters.getDistId());


            long rowID = db.insert(ClusterTable.TABLE_NAME, null, values);
            if (rowID != -1) insertCount++;
        }


        db.close();

        db.close();

        return insertCount;
    }

    public int syncRandom(JSONArray list) {
//        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(RandomHHTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < list.length(); i++) {

                JSONObject json = list.getJSONObject(i);

                RandomHH ran = new RandomHH();
                ran.sync(json);
                ContentValues values = new ContentValues();
                values.put(RandomHHTable.COLUMN_ID, ran.getID());
                values.put(RandomHHTable.COLUMN_SNO, ran.getSno());
                values.put(RandomHHTable.COLUMN_CLUSTER_CODE, ran.getClusteCcode());
                values.put(RandomHHTable.COLUMN_HH_NO, ran.getHhno());
                values.put(RandomHHTable.COLUMN_HEAD_HH, ran.getHeadhh());
                long rowID = db.insert(RandomHHTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncRandom(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    //get UnSyncedTables
    public JSONArray getUnsyncedFormHH() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = FormsTable.COLUMN_SYNCED + " = '' AND " +
                FormsTable.COLUMN_ISTATUS + "!= ''";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        JSONArray allForms = new JSONArray();
        c = db.query(
                FormsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*Form fc = new Form();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedFormHH: " + c.getCount());
            Form form = new Form();
            allForms.put(form.Hydrate(c).toJSONObject());


        }

        c.close();
        db.close();

        Log.d(TAG, "getUnsyncedFormHH: " + allForms.toString().length());
        Log.d(TAG, "getUnsyncedFormHH: " + allForms);
        return allForms;
    }

    public JSONArray getUnsyncedFamilyMembers() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = FamilyMembersTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = FamilyMembersTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                FamilyMembersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedFamilyMembers: " + c.getCount());
            FamilyMembers fm = new FamilyMembers();
            all.put(fm.Hydrate(c).toJSONObject());
        }

        c.close();

        db.close();

        Log.d(TAG, "getUnsyncedFamilyMembers: " + all.toString().length());
        Log.d(TAG, "getUnsyncedFamilyMembers: " + all);
        return all;
    }

    public JSONArray getUnsyncedMWRA() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = MwraTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = MwraTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                MwraTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedMWRA: " + c.getCount());
            MWRA mwra = new MWRA();
            all.put(mwra.Hydrate(c).toJSONObject());
        }

        c.close();

        Log.d(TAG, "getUnsyncedMWRA: " + all.toString().length());
        Log.d(TAG, "getUnsyncedMWRA: " + all);
        return all;
    }

    public JSONArray getUnsyncedPregnancyDetails() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = PregnancyDetailsTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = PregnancyDetailsTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                PregnancyDetailsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedPregnancy: " + c.getCount());
            PregnancyDetails pregD = new PregnancyDetails();
            all.put(pregD.Hydrate(c).toJSONObject());
        }

        c.close();

        Log.d(TAG, "getUnsyncedPregnancy: " + all.toString().length());
        Log.d(TAG, "getUnsyncedPregnancy: " + all);
        return all;
    }

    public JSONArray getUnsyncedPregnancyMaster() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = PregnancyMasterTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = PregnancyMasterTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                PregnancyMasterTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedPregnancy: " + c.getCount());
            PregnancyMaster pregM = new PregnancyMaster();
            all.put(pregM.Hydrate(c).toJSONObject());
        }

        c.close();

        Log.d(TAG, "getUnsyncedPregnancy: " + all.toString().length());
        Log.d(TAG, "getUnsyncedPregnancy: " + all);
        return all;
    }

    public JSONArray getUnsyncedMortalityTable() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = MaternalMortalityTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = MaternalMortalityTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                MaternalMortalityTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedMortalityTable: " + c.getCount());
            MaternalMortality maternalMortality = new MaternalMortality();
            all.put(maternalMortality.Hydrate(c).toJSONObject());
        }

        c.close();

        Log.d(TAG, "getUnsyncedMortalityTable: " + all.toString().length());
        Log.d(TAG, "getUnsyncedMortalityTable: " + all);
        return all;
    }

    public JSONArray getUnsyncedChild() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = ChildTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = ChildTable.COLUMN_ID + " ASC";

        JSONArray allChild = new JSONArray();
        c = db.query(
                ChildTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedChild: " + c.getCount());
            Child ch = new Child();
            allChild.put(ch.Hydrate(c).toJSONObject());
        }

        Log.d(TAG, "getUnsyncedChild: " + allChild.toString().length());
        Log.d(TAG, "getUnsyncedChild: " + allChild);
        return allChild;
    }

    public JSONArray getUnsyncedChildARI() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = ChildARITable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = ChildARITable.COLUMN_ID + " ASC";

        JSONArray allChildARI = new JSONArray();
        c = db.query(
                ChildARITable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedChildARI: " + c.getCount());
            ChildARI ch = new ChildARI();
            allChildARI.put(ch.Hydrate(c).toJSONObject());
        }

        Log.d(TAG, "getUnsyncedChildARI: " + allChildARI.toString().length());
        Log.d(TAG, "getUnsyncedChildARI: " + allChildARI);
        return allChildARI;
    }

    public JSONArray getUnsyncedChildDIA() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = ChildDIATable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = ChildDIATable.COLUMN_ID + " ASC";

        JSONArray allChildDIA = new JSONArray();
        c = db.query(
                ChildDIATable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedChildDIA " + c.getCount());
            ChildDIA childDIA = new ChildDIA();
            allChildDIA.put(childDIA.Hydrate(c).toJSONObject());
        }

        Log.d(TAG, "getUnsyncedChildDIA: " + allChildDIA.toString().length());
        Log.d(TAG, "getUnsyncedChildDIA: " + allChildDIA);
        return allChildDIA;
    }

    public JSONArray getUnsyncedEntryLog() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = EntryLogTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = EntryLogTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                EntryLogTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedEntryLog: " + c.getCount());
            EntryLog entryLog = new EntryLog();
            all.put(entryLog.Hydrate(c).toJSONObject());
        }
        Log.d(TAG, "getUnsyncedEntryLog: " + all.toString().length());
        Log.d(TAG, "getUnsyncedEntryLog: " + all);
        return all;
    }


    //update SyncedTables
    public void updateSyncedFormHH(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNC_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedFamilyMembers(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(FamilyMembersTable.COLUMN_SYNCED, true);
        values.put(FamilyMembersTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = FamilyMembersTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                FamilyMembersTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedMWRA(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(MwraTable.COLUMN_SYNCED, true);
        values.put(MwraTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = MwraTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                MwraTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedPregnancyDetails(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(PregnancyDetailsTable.COLUMN_SYNCED, true);
        values.put(PregnancyDetailsTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = PregnancyDetailsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                PregnancyDetailsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedPregnancyMaster(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(PregnancyMasterTable.COLUMN_SYNCED, true);
        values.put(PregnancyMasterTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = PregnancyMasterTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                PregnancyMasterTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedMaternalMortality(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(MaternalMortalityTable.COLUMN_SYNCED, true);
        values.put(MaternalMortalityTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = MaternalMortalityTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                MaternalMortalityTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedChild(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SYNCED, true);
        values.put(ChildTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = ChildTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                ChildTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedChildARI(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(ChildARITable.COLUMN_SYNCED, true);
        values.put(ChildARITable.COLUMN_SYNC_DATE, new Date().toString());
        String where = ChildARITable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                ChildARITable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedChildDIA(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(ChildDIATable.COLUMN_SYNCED, true);
        values.put(ChildDIATable.COLUMN_SYNC_DATE, new Date().toString());
        String where = ChildDIATable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                ChildDIATable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedEntryLog(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_SYNCED, true);
        values.put(EntryLogTable.COLUMN_SYNC_DATE, new Date().toString());
        String where = EntryLogTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};
        int count = db.update(
                EntryLogTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    /*public RandomHH checkHousehold(String cluster_no, String hh_no) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String selection = RandomHHTable.COLUMN_CLUSTER_CODE + "= ? AND "
                + RandomHHTable.COLUMN_HH_NO + "= ? ";
        String[] selectionArgs = {cluster_no, hh_no};

        int cCount;
        RandomHH hh = null;
        try {
            c = db.query(
                    RandomHHTable.TABLE_NAME,
                    columns,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
            );
            while (c.moveToNext()) {

                hh = new RandomHH().hydrate(c);

            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }

        return hh;

    }*/

    public Form getFormByPsuHHNo(String psuCode, String hhid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_PSU_CODE + "=? AND " +
                FormsTable.COLUMN_HHID + " =? ";

        String[] whereArgs = {psuCode, hhid};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form form = null;
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                form = new Form().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return form;
    }


    public List<Form> getFormsByCluster(String cluster) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_PSU_CODE + " = ? ";
        String[] whereArgs = new String[]{cluster};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        List<Form> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                fc.setPsuCode(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_PSU_CODE)));
                fc.setHhid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_HHID)));
                fc.setSno(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SNO)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public List<Form> getTodayForms(String sysdate) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " DESC";

        List<Form> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                fc.setPsuCode(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_PSU_CODE)));
                fc.setHhid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_HHID)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public List<Form> getPendingForms() {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_ISTATUS + " = ?";
        String[] whereArgs = new String[]{""};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " DESC";

        List<Form> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE)));
                fc.setPsuCode(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_PSU_CODE)));
                fc.setHhid(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_HHID)));
                fc.setSno(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SNO)));
                fc.setiStatus(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public String getDistrictNameByCode() {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause = ClusterTable.COLUMN_DIST_ID + " = ?";

        String[] whereArgs = {MainApp.selectedDistrict};

        String groupBy = null;
        String having = null;

        String orderBy = ClusterTable.COLUMN_GEOAREA + " ASC";

        String cl = null;
            c = db.query(
                    ClusterTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy,
                    "1"
            );
        while (c.moveToNext()) {
            cl = new Clusters().hydrate(c).getGeoarea();
        }
        c.close();
        db.close();

        return cl;

    }

    /*public RandomHH getHHbyEnumBlocks(String psuCode, String hhno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = RandomHHTable.COLUMN_CLUSTER_CODE + " = ? AND " +
                RandomHHTable.COLUMN_HH_NO + " = ?";

        String[] whereArgs = {psuCode, hhno};

        String groupBy = null;
        String having = null;

        String orderBy = RandomHHTable.COLUMN_HH_NO + " ASC";

        String limit = "5000";

        RandomHH randHH = new RandomHH();
        try {
            c = db.query(true,
                    RandomHHTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy,
                    limit
                    // The sort order
            );
            while (c.moveToNext()) {
                randHH = new RandomHH().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return randHH;
    }*/

    public List<FamilyMembers> getMemberBYUID(String uid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FamilyMembersTable.COLUMN_UUID + "=?";

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FamilyMembersTable.COLUMN_ID + " ASC";

        ArrayList<FamilyMembers> membersByUID = new ArrayList<>();
        try {
            c = db.query(
                    FamilyMembersTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FamilyMembers mwra = new FamilyMembers().Hydrate(c);

                membersByUID.add(mwra);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return membersByUID;
    }

    public FamilyMembers getSelectedMemberBYUID(String uid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FamilyMembersTable.COLUMN_UUID + "=? AND "
                + FamilyMembersTable.COLUMN_INDEXED + "=?";

        String[] whereArgs = {uid, "1"};

        String groupBy = null;
        String having = null;

        String orderBy = FamilyMembersTable.COLUMN_ID + " ASC";

        FamilyMembers membersByUID = new FamilyMembers();
        try {
            c = db.query(
                    FamilyMembersTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                membersByUID = new FamilyMembers().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return membersByUID;
    }

    /*public List<FoodConsumption> getFoodConsumptionBYUID(String uid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FoodConsumptionTable.COLUMN_UUID + "=? ";

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FoodConsumptionTable.COLUMN_ID + " ASC";

        List<FoodConsumption> foodConsumption = new ArrayList<>();
        try {
            c = db.query(
                    FoodConsumptionTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                foodConsumption.add(new FoodConsumption().Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return foodConsumption;
    }*/

    public int updatesfamilyListColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FamilyMembersTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.familyMember.getId())};

        return db.update(FamilyMembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    public Form getFormByPSUHHNo(String psuCode, String hhid) throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;

        Boolean distinct = false;
        String tableName = FormsTable.TABLE_NAME;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_PSU_CODE + "= ? AND " +
                FormsTable.COLUMN_HHID + "= ? ";
        String[] whereArgs = {psuCode, hhid};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_SYSDATE + " ASC";
        String limitRows = "1";

        c = db.query(
                distinct,       // Distinct values
                tableName,      // The table to query
                columns,        // The columns to return
                whereClause,    // The columns for the WHERE clause
                whereArgs,      // The values for the WHERE clause
                groupBy,        // don't group the rows
                having,         // don't filter by row groups
                orderBy,
                limitRows
        );

        Form form = new Form();
        while (c.moveToNext()) {
            form = (new Form().Hydrate(c));
        }

        c.close();
        db.close();
        return form;

    }


    public MWRA getMwraByUUid() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = MwraTable.COLUMN_UUID + "=? ";

        String[] whereArgs = {MainApp.form.getUid()};

        String groupBy = null;
        String having = null;

        String orderBy = MwraTable.COLUMN_ID + " ASC";

        MWRA mwra = new MWRA();

        c = db.query(
                MwraTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            mwra = new MWRA().Hydrate(c);
        }

        db.close();

        return mwra;
    }

    public PregnancyMaster getPregMByFmuid(String fmuid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause =
                PregnancyMasterTable.COLUMN_UUID + "=? AND " +
                        PregnancyMasterTable.COLUMN_FMUID + "=? "
        ;

        String[] whereArgs = {MainApp.form.getUid(), fmuid};

        String groupBy = null;
        String having = null;

        String orderBy = PregnancyMasterTable.COLUMN_ID + " ASC";

        PregnancyMaster pregnancyM = new PregnancyMaster();  // Pregnancies can never be null.

        c = db.query(
                PregnancyMasterTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            pregnancyM = new PregnancyMaster().Hydrate(c);
        }

        db.close();

        return pregnancyM;
    }


    public List<PregnancyDetails> getPregDByFmuid(String fmuid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause =
                PregnancyDetailsTable.COLUMN_UUID + "=? AND " +
                        PregnancyDetailsTable.COLUMN_FMUID + "=? ";

        String[] whereArgs = {MainApp.form.getUid(), fmuid};

        String groupBy = null;
        String having = null;

        String orderBy = PregnancyDetailsTable.COLUMN_ID + " ASC";

        List<PregnancyDetails> pregnancyD = new ArrayList<>();  // Pregnancies can never be null.

        c = db.query(
                PregnancyDetailsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            pregnancyD.add(new PregnancyDetails().Hydrate(c));
        }

        db.close();

        return pregnancyD;
    }

    public PregnancyDetails getPregDByPsno(String fmuid, String pSno) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause =
                PregnancyDetailsTable.COLUMN_UUID + "=? AND " +
                        PregnancyDetailsTable.COLUMN_FMUID + "=? AND " +
                        PregnancyDetailsTable.COLUMN_PSNO + "=?";

        String[] whereArgs = {MainApp.form.getUid(), fmuid, pSno};

        String groupBy = null;
        String having = null;

        String orderBy = PregnancyDetailsTable.COLUMN_ID + " ASC";

        PregnancyDetails pregnancyD = new PregnancyDetails();  // Pregnancies can never be null.

        c = db.query(
                PregnancyDetailsTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            pregnancyD = new PregnancyDetails().Hydrate(c);
        }

        db.close();

        return pregnancyD;
    }

    public List<PregnancyMaster> getPregByUUid() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause =
                PregnancyMasterTable.COLUMN_UUID + "=? "
        ;

        String[] whereArgs = {MainApp.form.getUid()};

        String groupBy = null;
        String having = null;

        String orderBy = PregnancyMasterTable.COLUMN_ID + " ASC";

        List<PregnancyMaster> pregnancyM = new ArrayList<>();  // Pregnancies can never be null.

        c = db.query(
                PregnancyMasterTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            pregnancyM.add(new PregnancyMaster().Hydrate(c));
        }

        db.close();

        return pregnancyM;
    }

    public MaternalMortality getMortalityBySno(String sno) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause =
                MaternalMortalityTable.COLUMN_UUID + "=? AND " +
                        MaternalMortalityTable.COLUMN_SNO + "=?";

        String[] whereArgs = {MainApp.form.getUid(), sno};

        String groupBy = null;
        String having = null;

        String orderBy = MaternalMortalityTable.COLUMN_ID + " ASC";

        MaternalMortality mortality = new MaternalMortality();  // Pregnancies can never be null.

        c = db.query(
                MaternalMortalityTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            mortality = new MaternalMortality().Hydrate(c);
        }

        db.close();

        return mortality;
    }

    public Child getChildByUUid() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = ChildTable.COLUMN_UUID + "=? ";

        String[] whereArgs = {MainApp.form.getUid()};

        String groupBy = null;
        String having = null;

        String orderBy = ChildTable.COLUMN_ID + " ASC";

        Child child = new Child();  // Pregnancies can never be null.

        c = db.query(
                ChildTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            child = new Child().Hydrate(c);
        }

        db.close();

        return child;
    }

    public ChildDIA getChildDIAByUUid() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = ChildDIATable.COLUMN_UUID + "=?";

        String[] whereArgs = {MainApp.form.getUid()};

        String groupBy = null;
        String having = null;

        String orderBy = ChildDIATable.COLUMN_ID + " ASC";

        ChildDIA childDIA = new ChildDIA();  // Pregnancies can never be null.

        c = db.query(
                ChildDIATable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            childDIA = new ChildDIA().Hydrate(c);
        }

        db.close();

        return childDIA;
    }


    public ChildARI getChildARIByUUid() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = ChildARITable.COLUMN_UUID + "=? ";

        String[] whereArgs = {MainApp.form.getUid()};

        String groupBy = null;
        String having = null;

        String orderBy = ChildARITable.COLUMN_ID + " ASC";

        ChildARI childARI = new ChildARI();  // Pregnancies can never be null.

        c = db.query(
                ChildARITable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            childARI = new ChildARI().Hydrate(c);
        }

        db.close();

        return childARI;
    }

    public int getSNoYoungestChild() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause = FamilyMembersTable.COLUMN_UUID + "=? AND " +
                FamilyMembersTable.COLUMN_MOTHER_PRESENT + "='1' AND " +
                "CAST(" + FamilyMembersTable.COLUMN_AGE_MONTHS + " AS INTEGER) < 1825 ";

        String[] whereArgs = {MainApp.form.getUid()};

        String groupBy = null;
        String having = null;

        // Not working
        String orderBy = "CAST(" + FamilyMembersTable.COLUMN_AGE_MONTHS + " AS INTEGER) ASC";
        //String orderBy = null;

        c = db.query(
                FamilyMembersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy,                    // The sort order
                "1"
        );
        int chSNo = 999;

        c.moveToFirst();
        chSNo = Integer.parseInt(new FamilyMembers().Hydrate(c).getD101());

        db.close();

        return chSNo;
    }


    public RandomHH getHHbyCluster(String clustercode, String hhno) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause = RandomHHTable.COLUMN_CLUSTER_CODE + " = ? AND " +
                RandomHHTable.COLUMN_HH_NO + " = ?";

        String[] whereArgs = {clustercode, hhno};

        String groupBy = null;
        String having = null;

        String orderBy = RandomHHTable.COLUMN_HH_NO + " ASC";

        String limit = "5000";

        RandomHH randHH = new RandomHH();
        c = db.query(true,
                RandomHHTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy,
                limit
                // The sort order
        );
        while (c.moveToNext()) {
            randHH = new RandomHH().hydrate(c);
        }

        c.close();

        db.close();


        return randHH;
    }

    public List<FamilyMembers> getAllRespondents() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause;
        whereClause = FamilyMembersTable.COLUMN_UUID + "=? ";

        String[] whereArgs = {MainApp.form.getUid()};

        String groupBy = null;
        String having = null;

        String orderBy = FamilyMembersTable.COLUMN_ID + " ASC";

        List<FamilyMembers> resp = new ArrayList<>();

        c = db.query(
                FamilyMembersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            FamilyMembers fm = new FamilyMembers().Hydrate(c);
            if (Integer.parseInt(fm.getD109y()) > 15)
                resp.add(fm);
        }

        db.close();

        return resp;
    }


    public Clusters getCluster(String cluster_no) {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause = ClusterTable.COLUMN_CLUSTER_NO + " =?";
        String[] whereArgs = new String[]{cluster_no};
        String groupBy = null;
        String having = null;

        String orderBy =
                ClusterTable._ID + " ASC";

        Clusters cluster = new Clusters();

        c = db.query(
                ClusterTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            cluster = new Clusters().hydrate(c);
        }

        c.close();

        db.close();

        return cluster;

    }

    public List<FamilyMembers> AllChildrenByMUID(String muid) throws JSONException {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause = FamilyMembersTable.COLUMN_UUID + "=? AND " +
                FamilyMembersTable.COLUMN_MUID + "=?";

        String[] whereArgs = {MainApp.form.getUid(), muid};

        String groupBy = null;
        String having = null;

        String orderBy = FamilyMembersTable.COLUMN_AGE_MONTHS + " ASC";

        c = db.query(
                FamilyMembersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order

        );
        List<FamilyMembers> allChildren = new ArrayList<>();
        while (c.moveToNext()) {
            allChildren.add(new FamilyMembers().Hydrate(c));
        }

        db.close();

        return allChildren;
    }

    public int updatePassword(String hashedPassword) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(UsersTable.COLUMN_PASSWORD, hashedPassword);
        values.put(UsersTable.COLUMN_ISNEW_USER, "");

        String selection = UsersTable.COLUMN_USERNAME + " =? ";
        String[] selectionArgs = {MainApp.user.getUserName()};

        return db.update(UsersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }
}
