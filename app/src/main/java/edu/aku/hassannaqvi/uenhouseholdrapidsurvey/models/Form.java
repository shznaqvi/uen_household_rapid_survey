package edu.aku.hassannaqvi.uenhouseholdrapidsurvey.models;

import static edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp._EMPTY_;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.BR;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.core.MainApp;


public class Form extends BaseObservable implements Observable {

    private final String TAG = "Form";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = PROJECT_NAME;
    // APP VARIABLES
    private String id = _EMPTY_;
    private String uid = _EMPTY_;
    private String userName = _EMPTY_;
    private String sysDate = _EMPTY_;
    private String psuCode = _EMPTY_;
    private String hhid = _EMPTY_;
    private String sno = _EMPTY_;
    private String deviceId = _EMPTY_;
    private String deviceTag = _EMPTY_;
    private String appver = _EMPTY_;
    private String endTime = _EMPTY_;
    private String iStatus = _EMPTY_;
    private String iStatus96x = _EMPTY_;
    private String synced = _EMPTY_;
    private String syncDate = _EMPTY_;
    private String entryType = _EMPTY_;

    // FIELD VARIABLES
    private String a104 = _EMPTY_;
    private String a105 = _EMPTY_;
    private String a106 = _EMPTY_;
    private String a107 = _EMPTY_;
    private String a101 = _EMPTY_;
    private String a102 = _EMPTY_;
    private String a108 = _EMPTY_;
    private String a103 = _EMPTY_;
    private String a113 = _EMPTY_;
    private String a109 = _EMPTY_;
    private String a110 = _EMPTY_;
    private String a111 = _EMPTY_;
    private String a112 = _EMPTY_;
    private String a11201 = _EMPTY_;
    private String a11201x = _EMPTY_;
    private String a11203 = _EMPTY_;
    private String c101 = _EMPTY_;
    private String c102 = _EMPTY_;
    private String c103 = _EMPTY_;
    private String m101 = _EMPTY_;
    private String m102 = _EMPTY_;
    private String m103 = _EMPTY_;
    private String m104 = _EMPTY_;
    private String m105 = _EMPTY_;
    private String m106 = _EMPTY_;
    private String m1071 = _EMPTY_;
    private String m1072 = _EMPTY_;
    private String m1073 = _EMPTY_;
    private String m1074 = _EMPTY_;
    private String m1075 = _EMPTY_;
    private String m1076 = _EMPTY_;
    private String m1077 = _EMPTY_;
    private String m1078 = _EMPTY_;
    private String m1079 = _EMPTY_;
    private String m018 = _EMPTY_;
    private String m109 = _EMPTY_;
    private String m110 = _EMPTY_;
    private String m11001x = _EMPTY_;
    private String m11002x = _EMPTY_;
    private String m111 = _EMPTY_;
    private String m112 = _EMPTY_;
    private String m11201 = _EMPTY_;
    private String m11201x = _EMPTY_;
    private String m11202 = _EMPTY_;
    private String m11202x = _EMPTY_;
    private String m11203 = _EMPTY_;
    private String m11203x = _EMPTY_;
    private String m11204 = _EMPTY_;
    private String m11204x = _EMPTY_;
    private String m11205 = _EMPTY_;
    private String m11205x = _EMPTY_;
    private String m11206 = _EMPTY_;
    private String m11206x = _EMPTY_;
    private String m11207 = _EMPTY_;
    private String m11207x = _EMPTY_;
    private String m113 = _EMPTY_;
    private String m1141 = _EMPTY_;
    private String m1142 = _EMPTY_;
    private String m1143 = _EMPTY_;
    private String m1144 = _EMPTY_;
    private String m1145 = _EMPTY_;
    private String m1146 = _EMPTY_;
    private String m1147 = _EMPTY_;
    private String m1148 = _EMPTY_;
    private String m1149 = _EMPTY_;
    private String m11410 = _EMPTY_;
    private String m11411 = _EMPTY_;
    private String m11412 = _EMPTY_;
    private String m11413 = _EMPTY_;
    private String m11414 = _EMPTY_;
    private String m11415 = _EMPTY_;
    private String m11416 = _EMPTY_;
    private String m11417 = _EMPTY_;
    private String m11418 = _EMPTY_;
    private String m115 = _EMPTY_;
    private String m116 = _EMPTY_;
    private String n101 = _EMPTY_;
    private String n102 = _EMPTY_;
    private String n103 = _EMPTY_;
    private String n104 = _EMPTY_;
    private String n10401x = _EMPTY_;
    private String n105 = _EMPTY_;
    private String n106 = _EMPTY_;
    private String n107 = _EMPTY_;
    private String n108 = _EMPTY_;
    private String n109 = _EMPTY_;
    private String n10901 = _EMPTY_;
    private String n10902 = _EMPTY_;
    private String n10903 = _EMPTY_;
    private String n10904 = _EMPTY_;
    private String n10905 = _EMPTY_;
    private String n10906 = _EMPTY_;
    private String n10907 = _EMPTY_;
    private String n110 = _EMPTY_;
    private String n111 = _EMPTY_;
    private String n112 = _EMPTY_;
    private String n113 = _EMPTY_;
    private String n11301x = _EMPTY_;
    private String o101 = _EMPTY_;
    private String o102 = _EMPTY_;
    private String o103 = _EMPTY_;
    private String o104 = _EMPTY_;
    private String o10401 = _EMPTY_;
    private String o10402 = _EMPTY_;
    private String o10403 = _EMPTY_;
    private String o10404 = _EMPTY_;
    private String o10497 = _EMPTY_;
    private String o105 = _EMPTY_;
    private String o106 = _EMPTY_;
    private String o107 = _EMPTY_;
    private String o10701 = _EMPTY_;
    private String o10702 = _EMPTY_;
    private String o10703 = _EMPTY_;
    private String o10704 = _EMPTY_;
    private String o10797 = _EMPTY_;
    private String o108 = _EMPTY_;
    private String o10896x = _EMPTY_;



    public Form() {

/*        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.appInfo.getAppVersion());
        setAppver(MainApp.appInfo.getAppVersion());*/

    }


    public void populateMeta() {

        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        //   setUuid(MainApp.form.getUid());  // not applicable in Form table
        setAppver(MainApp.appInfo.getAppVersion());
        setProjectName(PROJECT_NAME);
        setPsuCode(MainApp.selectedPSU);
        setHhid(MainApp.selectedHHID);
        setEntryType(String.valueOf(MainApp.entryType));

    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Bindable
    public String getPsuCode() {
        return psuCode;
    }

    public void setPsuCode(String psuCode) {
        this.psuCode = psuCode;
        notifyPropertyChanged(BR.psuCode);
    }

    @Bindable
    public String getHhid() {
        return hhid;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
        notifyPropertyChanged(BR.hhid);
    }

    @Bindable
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
        notifyPropertyChanged(BR.sno);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }




    @Bindable
    public String getA104() {
        return a104;
    }

    public void setA104(String a104) {
        this.a104 = a104;
        notifyPropertyChanged(BR.a104);
    }

    @Bindable
    public String getA105() {
        return a105;
    }

    public void setA105(String a105) {
        this.a105 = a105;
        notifyPropertyChanged(BR.a105);
    }

    @Bindable
    public String getA106() {
        return a106;
    }

    public void setA106(String a106) {
        this.a106 = a106;
        notifyPropertyChanged(BR.a106);
    }

    @Bindable
    public String getA107() {
        return a107;
    }

    public void setA107(String a107) {
        this.a107 = a107;
        notifyPropertyChanged(BR.a107);
    }

    @Bindable
    public String getA101() {
        return a101;
    }

    public void setA101(String a101) {
        this.a101 = a101;
        notifyPropertyChanged(BR.a101);
    }

    @Bindable
    public String getA102() {
        return a102;
    }

    public void setA102(String a102) {
        this.a102 = a102;
        notifyPropertyChanged(BR.a102);
    }

    @Bindable
    public String getA108() {
        return a108;
    }

    public void setA108(String a108) {
        this.a108 = a108;
        notifyPropertyChanged(BR.a108);
    }

    @Bindable
    public String getA103() {
        return a103;
    }

    public void setA103(String a103) {
        this.a103 = a103;
        notifyPropertyChanged(BR.a103);
    }

    @Bindable
    public String getA113() {
        return a113;
    }

    public void setA113(String a113) {
        this.a113 = a113;
        notifyPropertyChanged(BR.a113);
    }

    @Bindable
    public String getA109() {
        return a109;
    }

    public void setA109(String a109) {
        this.a109 = a109;
        notifyPropertyChanged(BR.a109);
    }

    @Bindable
    public String getA110() {
        return a110;
    }

    public void setA110(String a110) {
        this.a110 = a110;
        notifyPropertyChanged(BR.a110);
    }

    @Bindable
    public String getA111() {
        return a111;
    }

    public void setA111(String a111) {
        this.a111 = a111;
        notifyPropertyChanged(BR.a111);
    }

    @Bindable
    public String getA112() {
        return a112;
    }

    public void setA112(String a112) {
        this.a112 = a112;
        notifyPropertyChanged(BR.a112);
    }

    @Bindable
    public String getA11201() {
        return a11201;
    }

    public void setA11201(String a11201) {
        this.a11201 = a11201;
        notifyPropertyChanged(BR.a11201);
    }

    @Bindable
    public String getA11201x() {
        return a11201x;
    }

    public void setA11201x(String a11201x) {
        this.a11201x = a11201x;
        notifyPropertyChanged(BR.a11201x);
    }

    @Bindable
    public String getA11203() {
        return a11203;
    }

    public void setA11203(String a11203) {
        this.a11203 = a11203;
        notifyPropertyChanged(BR.a11203);
    }

    @Bindable
    public String getC101() {
        return c101;
    }

    public void setC101(String c101) {
        this.c101 = c101;
        notifyPropertyChanged(BR.c101);
    }

    @Bindable
    public String getC102() {
        return c102;
    }

    public void setC102(String c102) {
        this.c102 = c102;
        notifyPropertyChanged(BR.c102);
    }

    @Bindable
    public String getC103() {
        return c103;
    }

    public void setC103(String c103) {
        this.c103 = c103;
        notifyPropertyChanged(BR.c103);
    }

    @Bindable
    public String getM101() {
        return m101;
    }

    public void setM101(String m101) {
        this.m101 = m101;
        notifyPropertyChanged(BR.m101);
    }

    @Bindable
    public String getM102() {
        return m102;
    }

    public void setM102(String m102) {
        this.m102 = m102;
        notifyPropertyChanged(BR.m102);
    }

    @Bindable
    public String getM103() {
        return m103;
    }

    public void setM103(String m103) {
        this.m103 = m103;
        notifyPropertyChanged(BR.m103);
    }

    @Bindable
    public String getM104() {
        return m104;
    }

    public void setM104(String m104) {
        this.m104 = m104;
        notifyPropertyChanged(BR.m104);
    }

    @Bindable
    public String getM105() {
        return m105;
    }

    public void setM105(String m105) {
        this.m105 = m105;
        notifyPropertyChanged(BR.m105);
    }

    @Bindable
    public String getM106() {
        return m106;
    }

    public void setM106(String m106) {
        this.m106 = m106;
        notifyPropertyChanged(BR.m106);
    }

    @Bindable
    public String getM1071() {
        return m1071;
    }

    public void setM1071(String m1071) {
        this.m1071 = m1071;
        notifyPropertyChanged(BR.m1071);
    }

    @Bindable
    public String getM1072() {
        return m1072;
    }

    public void setM1072(String m1072) {
        this.m1072 = m1072;
        notifyPropertyChanged(BR.m1072);
    }

    @Bindable
    public String getM1073() {
        return m1073;
    }

    public void setM1073(String m1073) {
        this.m1073 = m1073;
        notifyPropertyChanged(BR.m1073);
    }

    @Bindable
    public String getM1074() {
        return m1074;
    }

    public void setM1074(String m1074) {
        this.m1074 = m1074;
        notifyPropertyChanged(BR.m1074);
    }

    @Bindable
    public String getM1075() {
        return m1075;
    }

    public void setM1075(String m1075) {
        this.m1075 = m1075;
        notifyPropertyChanged(BR.m1075);
    }

    @Bindable
    public String getM1076() {
        return m1076;
    }

    public void setM1076(String m1076) {
        this.m1076 = m1076;
        notifyPropertyChanged(BR.m1076);
    }

    @Bindable
    public String getM1077() {
        return m1077;
    }

    public void setM1077(String m1077) {
        this.m1077 = m1077;
        notifyPropertyChanged(BR.m1077);
    }

    @Bindable
    public String getM1078() {
        return m1078;
    }

    public void setM1078(String m1078) {
        this.m1078 = m1078;
        notifyPropertyChanged(BR.m1078);
    }

    @Bindable
    public String getM1079() {
        return m1079;
    }

    public void setM1079(String m1079) {
        this.m1079 = m1079;
        notifyPropertyChanged(BR.m1079);
    }

    @Bindable
    public String getM018() {
        return m018;
    }

    public void setM018(String m018) {
        this.m018 = m018;
        notifyPropertyChanged(BR.m018);
    }

    @Bindable
    public String getM109() {
        return m109;
    }

    public void setM109(String m109) {
        this.m109 = m109;
        notifyPropertyChanged(BR.m109);
    }

    @Bindable
    public String getM110() {
        return m110;
    }

    public void setM110(String m110) {
        this.m110 = m110;
        notifyPropertyChanged(BR.m110);
    }

    @Bindable
    public String getM11001x() {
        return m11001x;
    }

    public void setM11001x(String m11001x) {
        this.m11001x = m11001x;
        notifyPropertyChanged(BR.m11001x);
    }

    @Bindable
    public String getM11002x() {
        return m11002x;
    }

    public void setM11002x(String m11002x) {
        this.m11002x = m11002x;
        notifyPropertyChanged(BR.m11002x);
    }

    @Bindable
    public String getM111() {
        return m111;
    }

    public void setM111(String m111) {
        this.m111 = m111;
        notifyPropertyChanged(BR.m111);
    }

    @Bindable
    public String getM112() {
        return m112;
    }

    public void setM112(String m112) {
        this.m112 = m112;
        notifyPropertyChanged(BR.m112);
    }

    @Bindable
    public String getM11201() {
        return m11201;
    }

    public void setM11201(String m11201) {
        this.m11201 = m11201;
        notifyPropertyChanged(BR.m11201);
    }

    @Bindable
    public String getM11201x() {
        return m11201x;
    }

    public void setM11201x(String m11201x) {
        this.m11201x = m11201x;
        notifyPropertyChanged(BR.m11201x);
    }

    @Bindable
    public String getM11202() {
        return m11202;
    }

    public void setM11202(String m11202) {
        this.m11202 = m11202;
        notifyPropertyChanged(BR.m11202);
    }

    @Bindable
    public String getM11202x() {
        return m11202x;
    }

    public void setM11202x(String m11202x) {
        this.m11202x = m11202x;
        notifyPropertyChanged(BR.m11202x);
    }

    @Bindable
    public String getM11203() {
        return m11203;
    }

    public void setM11203(String m11203) {
        this.m11203 = m11203;
        notifyPropertyChanged(BR.m11203);
    }

    @Bindable
    public String getM11203x() {
        return m11203x;
    }

    public void setM11203x(String m11203x) {
        this.m11203x = m11203x;
        notifyPropertyChanged(BR.m11203x);
    }

    @Bindable
    public String getM11204() {
        return m11204;
    }

    public void setM11204(String m11204) {
        this.m11204 = m11204;
        notifyPropertyChanged(BR.m11204);
    }

    @Bindable
    public String getM11204x() {
        return m11204x;
    }

    public void setM11204x(String m11204x) {
        this.m11204x = m11204x;
        notifyPropertyChanged(BR.m11204x);
    }

    @Bindable
    public String getM11205() {
        return m11205;
    }

    public void setM11205(String m11205) {
        this.m11205 = m11205;
        notifyPropertyChanged(BR.m11205);
    }

    @Bindable
    public String getM11205x() {
        return m11205x;
    }

    public void setM11205x(String m11205x) {
        this.m11205x = m11205x;
        notifyPropertyChanged(BR.m11205x);
    }

    @Bindable
    public String getM11206() {
        return m11206;
    }

    public void setM11206(String m11206) {
        this.m11206 = m11206;
        notifyPropertyChanged(BR.m11206);
    }

    @Bindable
    public String getM11206x() {
        return m11206x;
    }

    public void setM11206x(String m11206x) {
        this.m11206x = m11206x;
        notifyPropertyChanged(BR.m11206x);
    }

    @Bindable
    public String getM11207() {
        return m11207;
    }

    public void setM11207(String m11207) {
        this.m11207 = m11207;
        notifyPropertyChanged(BR.m11207);
    }

    @Bindable
    public String getM11207x() {
        return m11207x;
    }

    public void setM11207x(String m11207x) {
        this.m11207x = m11207x;
        notifyPropertyChanged(BR.m11207x);
    }

    @Bindable
    public String getM113() {
        return m113;
    }

    public void setM113(String m113) {
        this.m113 = m113;
        notifyPropertyChanged(BR.m113);
    }

    @Bindable
    public String getM1141() {
        return m1141;
    }

    public void setM1141(String m1141) {
        this.m1141 = m1141;
        notifyPropertyChanged(BR.m1141);
    }

    @Bindable
    public String getM1142() {
        return m1142;
    }

    public void setM1142(String m1142) {
        this.m1142 = m1142;
        notifyPropertyChanged(BR.m1142);
    }

    @Bindable
    public String getM1143() {
        return m1143;
    }

    public void setM1143(String m1143) {
        this.m1143 = m1143;
        notifyPropertyChanged(BR.m1143);
    }

    @Bindable
    public String getM1144() {
        return m1144;
    }

    public void setM1144(String m1144) {
        this.m1144 = m1144;
        notifyPropertyChanged(BR.m1144);
    }

    @Bindable
    public String getM1145() {
        return m1145;
    }

    public void setM1145(String m1145) {
        this.m1145 = m1145;
        notifyPropertyChanged(BR.m1145);
    }

    @Bindable
    public String getM1146() {
        return m1146;
    }

    public void setM1146(String m1146) {
        this.m1146 = m1146;
        notifyPropertyChanged(BR.m1146);
    }

    @Bindable
    public String getM1147() {
        return m1147;
    }

    public void setM1147(String m1147) {
        this.m1147 = m1147;
        notifyPropertyChanged(BR.m1147);
    }

    @Bindable
    public String getM1148() {
        return m1148;
    }

    public void setM1148(String m1148) {
        this.m1148 = m1148;
        notifyPropertyChanged(BR.m1148);
    }

    @Bindable
    public String getM1149() {
        return m1149;
    }

    public void setM1149(String m1149) {
        this.m1149 = m1149;
        notifyPropertyChanged(BR.m1149);
    }

    @Bindable
    public String getM11410() {
        return m11410;
    }

    public void setM11410(String m11410) {
        this.m11410 = m11410;
        notifyPropertyChanged(BR.m11410);
    }

    @Bindable
    public String getM11411() {
        return m11411;
    }

    public void setM11411(String m11411) {
        this.m11411 = m11411;
        notifyPropertyChanged(BR.m11411);
    }

    @Bindable
    public String getM11412() {
        return m11412;
    }

    public void setM11412(String m11412) {
        this.m11412 = m11412;
        notifyPropertyChanged(BR.m11412);
    }

    @Bindable
    public String getM11413() {
        return m11413;
    }

    public void setM11413(String m11413) {
        this.m11413 = m11413;
        notifyPropertyChanged(BR.m11413);
    }

    @Bindable
    public String getM11414() {
        return m11414;
    }

    public void setM11414(String m11414) {
        this.m11414 = m11414;
        notifyPropertyChanged(BR.m11414);
    }

    @Bindable
    public String getM11415() {
        return m11415;
    }

    public void setM11415(String m11415) {
        this.m11415 = m11415;
        notifyPropertyChanged(BR.m11415);
    }

    @Bindable
    public String getM11416() {
        return m11416;
    }

    public void setM11416(String m11416) {
        this.m11416 = m11416;
        notifyPropertyChanged(BR.m11416);
    }

    @Bindable
    public String getM11417() {
        return m11417;
    }

    public void setM11417(String m11417) {
        this.m11417 = m11417;
        notifyPropertyChanged(BR.m11417);
    }

    @Bindable
    public String getM11418() {
        return m11418;
    }

    public void setM11418(String m11418) {
        this.m11418 = m11418;
        notifyPropertyChanged(BR.m11418);
    }

    @Bindable
    public String getM115() {
        return m115;
    }

    public void setM115(String m115) {
        this.m115 = m115;
        notifyPropertyChanged(BR.m115);
    }

    @Bindable
    public String getM116() {
        return m116;
    }

    public void setM116(String m116) {
        this.m116 = m116;
        notifyPropertyChanged(BR.m116);
    }

    @Bindable
    public String getN101() {
        return n101;
    }

    public void setN101(String n101) {
        this.n101 = n101;
        notifyPropertyChanged(BR.n101);
    }

    @Bindable
    public String getN102() {
        return n102;
    }

    public void setN102(String n102) {
        this.n102 = n102;
        notifyPropertyChanged(BR.n102);
    }

    @Bindable
    public String getN103() {
        return n103;
    }

    public void setN103(String n103) {
        this.n103 = n103;
        notifyPropertyChanged(BR.n103);
    }

    @Bindable
    public String getN104() {
        return n104;
    }

    public void setN104(String n104) {
        this.n104 = n104;
        notifyPropertyChanged(BR.n104);
    }

    @Bindable
    public String getN10401x() {
        return n10401x;
    }

    public void setN10401x(String n10401x) {
        this.n10401x = n10401x;
        notifyPropertyChanged(BR.n10401x);
    }

    @Bindable
    public String getN105() {
        return n105;
    }

    public void setN105(String n105) {
        this.n105 = n105;
        notifyPropertyChanged(BR.n105);
    }

    @Bindable
    public String getN106() {
        return n106;
    }

    public void setN106(String n106) {
        this.n106 = n106;
        notifyPropertyChanged(BR.n106);
    }

    @Bindable
    public String getN107() {
        return n107;
    }

    public void setN107(String n107) {
        this.n107 = n107;
        notifyPropertyChanged(BR.n107);
    }

    @Bindable
    public String getN108() {
        return n108;
    }

    public void setN108(String n108) {
        this.n108 = n108;
        notifyPropertyChanged(BR.n108);
    }

    @Bindable
    public String getN109() {
        return n109;
    }

    public void setN109(String n109) {
        this.n109 = n109;
        notifyPropertyChanged(BR.n109);
    }

    @Bindable
    public String getN10901() {
        return n10901;
    }

    public void setN10901(String n10901) {
        this.n10901 = n10901;
        notifyPropertyChanged(BR.n10901);
    }

    @Bindable
    public String getN10902() {
        return n10902;
    }

    public void setN10902(String n10902) {
        this.n10902 = n10902;
        notifyPropertyChanged(BR.n10902);
    }

    @Bindable
    public String getN10903() {
        return n10903;
    }

    public void setN10903(String n10903) {
        this.n10903 = n10903;
        notifyPropertyChanged(BR.n10903);
    }

    @Bindable
    public String getN10904() {
        return n10904;
    }

    public void setN10904(String n10904) {
        this.n10904 = n10904;
        notifyPropertyChanged(BR.n10904);
    }

    @Bindable
    public String getN10905() {
        return n10905;
    }

    public void setN10905(String n10905) {
        this.n10905 = n10905;
        notifyPropertyChanged(BR.n10905);
    }

    @Bindable
    public String getN10906() {
        return n10906;
    }

    public void setN10906(String n10906) {
        this.n10906 = n10906;
        notifyPropertyChanged(BR.n10906);
    }

    @Bindable
    public String getN10907() {
        return n10907;
    }

    public void setN10907(String n10907) {
        this.n10907 = n10907;
        notifyPropertyChanged(BR.n10907);
    }

    @Bindable
    public String getN110() {
        return n110;
    }

    public void setN110(String n110) {
        this.n110 = n110;
        notifyPropertyChanged(BR.n110);
    }

    @Bindable
    public String getN111() {
        return n111;
    }

    public void setN111(String n111) {
        this.n111 = n111;
        notifyPropertyChanged(BR.n111);
    }

    @Bindable
    public String getN112() {
        return n112;
    }

    public void setN112(String n112) {
        this.n112 = n112;
        notifyPropertyChanged(BR.n112);
    }

    @Bindable
    public String getN113() {
        return n113;
    }

    public void setN113(String n113) {
        this.n113 = n113;
        notifyPropertyChanged(BR.n113);
    }

    @Bindable
    public String getN11301x() {
        return n11301x;
    }

    public void setN11301x(String n11301x) {
        this.n11301x = n11301x;
        notifyPropertyChanged(BR.n11301x);
    }

    @Bindable
    public String getO101() {
        return o101;
    }

    public void setO101(String o101) {
        this.o101 = o101;
        notifyPropertyChanged(BR.o101);
    }

    @Bindable
    public String getO102() {
        return o102;
    }

    public void setO102(String o102) {
        this.o102 = o102;
        notifyPropertyChanged(BR.o102);
    }

    @Bindable
    public String getO103() {
        return o103;
    }

    public void setO103(String o103) {
        this.o103 = o103;
        notifyPropertyChanged(BR.o103);
    }

    @Bindable
    public String getO104() {
        return o104;
    }

    public void setO104(String o104) {
        this.o104 = o104;
        notifyPropertyChanged(BR.o104);
    }

    @Bindable
    public String getO10401() {
        return o10401;
    }

    public void setO10401(String o10401) {
        this.o10401 = o10401;
        notifyPropertyChanged(BR.o10401);
    }

    @Bindable
    public String getO10402() {
        return o10402;
    }

    public void setO10402(String o10402) {
        this.o10402 = o10402;
        notifyPropertyChanged(BR.o10402);
    }

    @Bindable
    public String getO10403() {
        return o10403;
    }

    public void setO10403(String o10403) {
        this.o10403 = o10403;
        notifyPropertyChanged(BR.o10403);
    }

    @Bindable
    public String getO10404() {
        return o10404;
    }

    public void setO10404(String o10404) {
        this.o10404 = o10404;
        notifyPropertyChanged(BR.o10404);
    }

    @Bindable
    public String getO10497() {
        return o10497;
    }

    public void setO10497(String o10497) {
        this.o10497 = o10497;
        notifyPropertyChanged(BR.o10497);
    }

    @Bindable
    public String getO105() {
        return o105;
    }

    public void setO105(String o105) {
        this.o105 = o105;
        notifyPropertyChanged(BR.o105);
    }

    @Bindable
    public String getO106() {
        return o106;
    }

    public void setO106(String o106) {
        this.o106 = o106;
        notifyPropertyChanged(BR.o106);
    }

    @Bindable
    public String getO107() {
        return o107;
    }

    public void setO107(String o107) {
        this.o107 = o107;
        notifyPropertyChanged(BR.o107);
    }

    @Bindable
    public String getO10701() {
        return o10701;
    }

    public void setO10701(String o10701) {
        this.o10701 = o10701;
        notifyPropertyChanged(BR.o10701);
    }

    @Bindable
    public String getO10702() {
        return o10702;
    }

    public void setO10702(String o10702) {
        this.o10702 = o10702;
        notifyPropertyChanged(BR.o10702);
    }

    @Bindable
    public String getO10703() {
        return o10703;
    }

    public void setO10703(String o10703) {
        this.o10703 = o10703;
        notifyPropertyChanged(BR.o10703);
    }

    @Bindable
    public String getO10704() {
        return o10704;
    }

    public void setO10704(String o10704) {
        this.o10704 = o10704;
        notifyPropertyChanged(BR.o10704);
    }

    @Bindable
    public String getO10797() {
        return o10797;
    }

    public void setO10797(String o10797) {
        this.o10797 = o10797;
        notifyPropertyChanged(BR.o10797);
    }

    @Bindable
    public String getO108() {
        return o108;
    }

    public void setO108(String o108) {
        this.o108 = o108;
        notifyPropertyChanged(BR.o108);
    }

    @Bindable
    public String getO10896x() {
        return o10896x;
    }

    public void setO10896x(String o10896x) {
        this.o10896x = o10896x;
        notifyPropertyChanged(BR.o10896x);
    }


    public Form Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_UID));
        this.projectName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_PROJECT_NAME));
        this.psuCode = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_PSU_CODE));
        this.hhid = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_HHID));
        this.sno = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SNO));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICETAGID));
        this.entryType = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ENTRY_TYPE));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYNCED_DATE));

        sA1Hydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SA1)));
        return this;
    }

    public void sA1Hydrate(String string) throws JSONException {
        Log.d(TAG, "sA1Hydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.a101 = json.getString("a101");
        }
    }


    public String sA1toString() throws JSONException {
        Log.d(TAG, "sA1toString: ");
        JSONObject json = new JSONObject();
        json.put("a101", a101);
        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this.id);
        json.put(FormsTable.COLUMN_UID, this.uid);
        json.put(FormsTable.COLUMN_PROJECT_NAME, this.projectName);
        json.put(FormsTable.COLUMN_PSU_CODE, this.psuCode);
        json.put(FormsTable.COLUMN_HHID, this.hhid);
        json.put(FormsTable.COLUMN_SNO, this.sno);
        json.put(FormsTable.COLUMN_USERNAME, this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(FormsTable.COLUMN_ENTRY_TYPE, this.entryType);
        json.put(FormsTable.COLUMN_ISTATUS, this.iStatus);
        json.put(FormsTable.COLUMN_SYNCED, this.synced);
        json.put(FormsTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(FormsTable.COLUMN_APPVERSION, this.appver);
        json.put(FormsTable.COLUMN_SA1, new JSONObject(sA1toString()));
        return json;
    }


}
