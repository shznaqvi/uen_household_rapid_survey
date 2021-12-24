package edu.aku.hassannaqvi.uenhouseholdrapidsurvey.database


import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.*


object CreateTable {


    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_PSU_CODE + " TEXT,"
            + FormsTable.COLUMN_HHID + " TEXT,"
            + FormsTable.COLUMN_SNO + " TEXT,"
            + FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsTable.COLUMN_DEVICETAGID + " TEXT,"
/*
            + FormsTable.COLUMN_ENTRY_TYPE + " TEXT,"
*/
            + FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsTable.COLUMN_SA + " TEXT,"
            + FormsTable.COLUMN_SM + " TEXT,"
            + FormsTable.COLUMN_SN + " TEXT,"
            + FormsTable.COLUMN_SO + " TEXT,"
            + FormsTable.COLUMN_SE2 + " TEXT"
            + " );"
            )
    const val SQL_CREATE_ENTRYLOGS = ("CREATE TABLE "
            + EntryLogTable.TABLE_NAME + "("
            + EntryLogTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EntryLogTable.COLUMN_PROJECT_NAME + " TEXT,"
            + EntryLogTable.COLUMN_UID + " TEXT,"
            + EntryLogTable.COLUMN_UUID + " TEXT,"
            + EntryLogTable.COLUMN_PSU_CODE + " TEXT,"
            + EntryLogTable.COLUMN_HHID + " TEXT,"
            + EntryLogTable.COLUMN_USERNAME + " TEXT,"
            + EntryLogTable.COLUMN_SYSDATE + " TEXT,"
            + EntryLogTable.COLUMN_DEVICEID + " TEXT,"
            + EntryLogTable.COLUMN_ENTRY_DATE + " TEXT,"
            + EntryLogTable.COLUMN_ISTATUS + " TEXT,"
            + EntryLogTable.COLUMN_ISTATUS96x + " TEXT,"
            + EntryLogTable.COLUMN_ENTRY_TYPE + " TEXT,"
            + EntryLogTable.COLUMN_SYNCED + " TEXT,"
            + EntryLogTable.COLUMN_SYNCED_DATE + " TEXT,"
            + EntryLogTable.COLUMN_APPVERSION + " TEXT"
            + " );"
            )


    const val SQL_CREATE_FAMILYMEMBERS = ("CREATE TABLE "
            + FamilyMembersTable.TABLE_NAME + "("
            + FamilyMembersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FamilyMembersTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FamilyMembersTable.COLUMN_UID + " TEXT,"
            + FamilyMembersTable.COLUMN_UUID + " TEXT,"
            + FamilyMembersTable.COLUMN_PSU_CODE + " TEXT,"
            + FamilyMembersTable.COLUMN_HHID + " TEXT,"
            + FamilyMembersTable.COLUMN_SNO + " TEXT,"
            + FamilyMembersTable.COLUMN_USERNAME + " TEXT,"
            + FamilyMembersTable.COLUMN_SYSDATE + " TEXT,"
            + FamilyMembersTable.COLUMN_INDEXED + " TEXT,"
            + FamilyMembersTable.COLUMN_ISTATUS + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICEID + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICETAGID + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FamilyMembersTable.COLUMN_APPVERSION + " TEXT,"
            + FamilyMembersTable.COLUMN_SD + " TEXT"
            + " );"
            )

    /*    const val SQL_CREATE_FAMILY_MEMBERS = ("CREATE TABLE "
            + FamilyMembersTable.TABLE_NAME + "("
            + FamilyMembersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FamilyMembersTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FamilyMembersTable.COLUMN_UID + " TEXT,"
            + FamilyMembersTable.COLUMN_UUID + " TEXT,"
            + FamilyMembersTable.COLUMN_EB_CODE + " TEXT,"
            + FamilyMembersTable.COLUMN_HHID + " TEXT,"
            + FamilyMembersTable.COLUMN_USERNAME + " TEXT,"
            + FamilyMembersTable.COLUMN_SYSDATE + " TEXT,"
            + FamilyMembersTable.COLUMN_INDEXED + " TEXT,"
            + FamilyMembersTable.COLUMN_ISTATUS + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICEID + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICETAGID + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FamilyMembersTable.COLUMN_APPVERSION + " TEXT,"
            + FamilyMembersTable.COLUMN_SA2 + " TEXT"
            + " );"
            )*/


    const val SQL_CREATE_MWRA = ("CREATE TABLE "
            + MwraTable.TABLE_NAME + "("
            + MwraTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MwraTable.COLUMN_PROJECT_NAME + " TEXT,"
            + MwraTable.COLUMN_UID + " TEXT,"
            + MwraTable.COLUMN_UUID + " TEXT,"
            + MwraTable.COLUMN_FMUID + " TEXT,"
            + MwraTable.COLUMN_SNO + " TEXT,"
            + MwraTable.COLUMN_PSU_CODE + " TEXT,"
            + MwraTable.COLUMN_HHID + " TEXT,"
            + MwraTable.COLUMN_USERNAME + " TEXT,"
            + MwraTable.COLUMN_SYSDATE + " TEXT,"
            + MwraTable.COLUMN_INDEXED + " TEXT,"
            + MwraTable.COLUMN_ISTATUS + " TEXT,"
            + MwraTable.COLUMN_DEVICEID + " TEXT,"
            + MwraTable.COLUMN_DEVICETAGID + " TEXT,"
            + MwraTable.COLUMN_SYNCED + " TEXT,"
            + MwraTable.COLUMN_SYNCED_DATE + " TEXT,"
            + MwraTable.COLUMN_APPVERSION + " TEXT,"
            + MwraTable.COLUMN_SF + " TEXT,"
            + MwraTable.COLUMN_SG + " TEXT,"
            + MwraTable.COLUMN_SH1 + " TEXT,"
            + MwraTable.COLUMN_SH2 + " TEXT,"
            + MwraTable.COLUMN_SK + " TEXT,"
            + MwraTable.COLUMN_SL + " TEXT,"
            + MwraTable.COLUMN_UN + " TEXT"
            + " );"
            )

    const val SQL_CREATE_PREGNANCY_DETAILS = ("CREATE TABLE "
            + PregnancyDetailsTable.TABLE_NAME + "("
            + PregnancyDetailsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PregnancyDetailsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + PregnancyDetailsTable.COLUMN_UID + " TEXT,"
            + PregnancyDetailsTable.COLUMN_UUID + " TEXT,"
            + PregnancyDetailsTable.COLUMN_FMUID + " TEXT,"
            + PregnancyDetailsTable.COLUMN_PSU_CODE + " TEXT,"
            + PregnancyDetailsTable.COLUMN_PSNO + " TEXT,"
            + PregnancyDetailsTable.COLUMN_MSNO + " TEXT,"
            + PregnancyDetailsTable.COLUMN_M_NAME + " TEXT,"
            + PregnancyDetailsTable.COLUMN_HHID + " TEXT,"
            + PregnancyDetailsTable.COLUMN_USERNAME + " TEXT,"
            + PregnancyDetailsTable.COLUMN_SYSDATE + " TEXT,"
            + PregnancyDetailsTable.COLUMN_ISTATUS + " TEXT,"
            + PregnancyDetailsTable.COLUMN_DEVICEID + " TEXT,"
            + PregnancyDetailsTable.COLUMN_DEVICETAGID + " TEXT,"
            + PregnancyDetailsTable.COLUMN_SYNCED + " TEXT,"
            + PregnancyDetailsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + PregnancyDetailsTable.COLUMN_APPVERSION + " TEXT,"
            + PregnancyDetailsTable.COLUMN_SE1 + " TEXT"
            + " );"
            )

    const val SQL_CREATE_PREGNANCY_MASTER = ("CREATE TABLE "
            + PregnancyMasterTable.TABLE_NAME + "("
            + PregnancyMasterTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PregnancyMasterTable.COLUMN_PROJECT_NAME + " TEXT,"
            + PregnancyMasterTable.COLUMN_UID + " TEXT,"
            + PregnancyMasterTable.COLUMN_UUID + " TEXT,"
            + PregnancyMasterTable.COLUMN_FMUID + " TEXT,"
            + PregnancyMasterTable.COLUMN_PSU_CODE + " TEXT,"
            + PregnancyMasterTable.COLUMN_SNO + " TEXT,"
            + PregnancyMasterTable.COLUMN_HHID + " TEXT,"
            + PregnancyMasterTable.COLUMN_USERNAME + " TEXT,"
            + PregnancyMasterTable.COLUMN_SYSDATE + " TEXT,"
            + PregnancyMasterTable.COLUMN_ISTATUS + " TEXT,"
            + PregnancyMasterTable.COLUMN_DEVICEID + " TEXT,"
            + PregnancyMasterTable.COLUMN_DEVICETAGID + " TEXT,"
            + PregnancyMasterTable.COLUMN_SYNCED + " TEXT,"
            + PregnancyMasterTable.COLUMN_SYNCED_DATE + " TEXT,"
            + PregnancyMasterTable.COLUMN_APPVERSION + " TEXT,"
            + PregnancyMasterTable.COLUMN_SE1 + " TEXT"

            + " );"
            )

    const val SQL_CREATE_MATERNAL_MORTIALITY = ("CREATE TABLE "
            + MaternalMortalityTable.TABLE_NAME + "("
            + MaternalMortalityTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MaternalMortalityTable.COLUMN_PROJECT_NAME + " TEXT,"
            + MaternalMortalityTable.COLUMN_UID + " TEXT,"
            + MaternalMortalityTable.COLUMN_UUID + " TEXT,"
            + MaternalMortalityTable.COLUMN_PSU_CODE + " TEXT,"
            + MaternalMortalityTable.COLUMN_SNO + " TEXT,"
            + MaternalMortalityTable.COLUMN_HHID + " TEXT,"
            + MaternalMortalityTable.COLUMN_USERNAME + " TEXT,"
            + MaternalMortalityTable.COLUMN_SYSDATE + " TEXT,"
            + MaternalMortalityTable.COLUMN_ISTATUS + " TEXT,"
            + MaternalMortalityTable.COLUMN_DEVICEID + " TEXT,"
            + MaternalMortalityTable.COLUMN_DEVICETAGID + " TEXT,"
            + MaternalMortalityTable.COLUMN_SYNCED + " TEXT,"
            + MaternalMortalityTable.COLUMN_SYNCED_DATE + " TEXT,"
            + MaternalMortalityTable.COLUMN_APPVERSION + " TEXT,"
            + MaternalMortalityTable.COLUMN_SE2 + " TEXT"

            + " );"
            )

    const val SQL_CREATE_CHILD = ("CREATE TABLE "
            + ChildTable.TABLE_NAME + "("
            + ChildTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ChildTable.COLUMN_PROJECT_NAME + " TEXT, "
            + ChildTable.COLUMN_UID + " TEXT, "
            + ChildTable.COLUMN_UUID + " TEXT, "
            + ChildTable.COLUMN_FMUID + " TEXT, "
            + ChildTable.COLUMN_MUID + " TEXT, "
            + ChildTable.COLUMN_PSU_CODE + " TEXT, "
            + ChildTable.COLUMN_HHID + " TEXT, "
            + ChildTable.COLUMN_SNO + " TEXT, "
            + ChildTable.COLUMN_USERNAME + " TEXT, "
            + ChildTable.COLUMN_SYSDATE + " TEXT, "
            + ChildTable.COLUMN_INDEXED + " TEXT, "
            + ChildTable.COLUMN_ISTATUS + " TEXT, "
            + ChildTable.COLUMN_DEVICEID + " TEXT, "
            + ChildTable.COLUMN_DEVICETAGID + " TEXT, "
            + ChildTable.COLUMN_SYNCED + " TEXT, "
            + ChildTable.COLUMN_SYNCED_DATE + " TEXT, "
            + ChildTable.COLUMN_APPVERSION + " TEXT, "
            + ChildTable.COLUMN_SIM + " TEXT "
            + " );"
            )

    const val SQL_CREATE_CHILD_ARI = ("CREATE TABLE "
            + ChildARITable.TABLE_NAME + "("
            + ChildARITable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildARITable.COLUMN_PROJECT_NAME + " TEXT,"
            + ChildARITable.COLUMN_UID + " TEXT,"
            + ChildARITable.COLUMN_UUID + " TEXT,"
            + ChildARITable.COLUMN_FMUID + " TEXT,"
            + ChildARITable.COLUMN_MUID + " TEXT,"
            + ChildARITable.COLUMN_PSU_CODE + " TEXT,"
            + ChildARITable.COLUMN_HHID + " TEXT,"
            + ChildARITable.COLUMN_SNO + " TEXT,"
            + ChildARITable.COLUMN_USERNAME + " TEXT,"
            + ChildARITable.COLUMN_SYSDATE + " TEXT,"
            + ChildARITable.COLUMN_INDEXED + " TEXT,"
            + ChildARITable.COLUMN_ISTATUS + " TEXT,"
            + ChildARITable.COLUMN_DEVICEID + " TEXT,"
            + ChildARITable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildARITable.COLUMN_SYNCED + " TEXT,"
            + ChildARITable.COLUMN_SYNCED_DATE + " TEXT,"
            + ChildARITable.COLUMN_APPVERSION + " TEXT,"
            + ChildARITable.COLUMN_SI2 + " TEXT"

            + " );"
            )

    const val SQL_CREATE_CHILD_DIA = ("CREATE TABLE "
            + ChildDIATable.TABLE_NAME + "("
            + ChildDIATable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildDIATable.COLUMN_PROJECT_NAME + " TEXT,"
            + ChildDIATable.COLUMN_UID + " TEXT,"
            + ChildDIATable.COLUMN_UUID + " TEXT,"
            + ChildDIATable.COLUMN_FMUID + " TEXT,"
            + ChildDIATable.COLUMN_MUID + " TEXT,"
            + ChildDIATable.COLUMN_PSU_CODE + " TEXT,"
            + ChildDIATable.COLUMN_HHID + " TEXT,"
            + ChildDIATable.COLUMN_SNO + " TEXT,"
            + ChildDIATable.COLUMN_USERNAME + " TEXT,"
            + ChildDIATable.COLUMN_SYSDATE + " TEXT,"
            + ChildDIATable.COLUMN_INDEXED + " TEXT,"
            + ChildDIATable.COLUMN_ISTATUS + " TEXT,"
            + ChildDIATable.COLUMN_DEVICEID + " TEXT,"
            + ChildDIATable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildDIATable.COLUMN_SYNCED + " TEXT,"
            + ChildDIATable.COLUMN_SYNCED_DATE + " TEXT,"
            + ChildDIATable.COLUMN_APPVERSION + " TEXT,"
            + ChildDIATable.COLUMN_SI1 + " TEXT"

            + " );"
            )


    const val SQL_CREATE_USERS = ("CREATE TABLE "
            + UsersTable.TABLE_NAME + "("
            + UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersTable.COLUMN_FULLNAME + " TEXT,"
            + UsersTable.COLUMN_DESIGNATION + " TEXT"
            + " );"
            )


    const val SQL_CREATE_VILLAGES = ("CREATE TABLE "
            + VillagesTable.TABLE_NAME + "("
            + VillagesTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VillagesTable.COLUMN_COUNTRY + " TEXT,"
            + VillagesTable.COLUMN_CCODE + " TEXT,"
            + VillagesTable.COLUMN_PROVINCE + " TEXT,"
            + VillagesTable.COLUMN_PROVCODE + " TEXT,"
            + VillagesTable.COLUMN_DISTRICT_NAME + " TEXT,"
            + VillagesTable.COLUMN_DCODE + " TEXT,"
            + VillagesTable.COLUMN_VILLAGE + " TEXT,"
            + VillagesTable.COLUMN_VCODE + " TEXT,"
            + VillagesTable.COLUMN_PSUCODE + " TEXT"
            + " );"
            )

    const val SQL_CREATE_CLUSTERS = ("CREATE TABLE "
            + ClusterTable.TABLE_NAME + "("
            + ClusterTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ClusterTable.COLUMN_CLUSTER_NO + " TEXT,"
            + ClusterTable.COLUMN_GEOAREA + " TEXT,"
            + ClusterTable.COLUMN_DIST_ID + " TEXT"
            + " );"
            )

    const val SQL_CREATE_RANDOM_HH = ("CREATE TABLE "
            + RandomHHTable.TABLE_NAME + "("
            + RandomHHTable.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + RandomHHTable.COLUMN_SNO + " TEXT,"
            + RandomHHTable.COLUMN_CLUSTER_CODE + " TEXT,"
            + RandomHHTable.COLUMN_HH_NO + " TEXT,"
            + RandomHHTable.COLUMN_HEAD_HH + " TEXT"
            + " );"
            )

    const val SQL_CREATE_VERSIONAPP = ("CREATE TABLE "
            + VersionTable.TABLE_NAME + " ("
            + VersionTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VersionTable.COLUMN_VERSION_CODE + " TEXT, "
            + VersionTable.COLUMN_VERSION_NAME + " TEXT, "
            + VersionTable.COLUMN_PATH_NAME + " TEXT "
            + ");"
            )


}