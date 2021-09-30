
import 'package:shared_preferences/shared_preferences.dart';

class Prefs {

  static late SharedPreferences _prefs;

  // call this method from iniState() function of mainApp().
  static Future<SharedPreferences> init() async {
    _prefs = await SharedPreferences.getInstance();
    return _prefs;
  }

  //sets
  static Future<bool> setLoginStatus(bool value) async => await _prefs.setBool("isLogin", value);
  static Future<bool> setFirstName(String value) async => await _prefs.setString("firstName", value);
  static Future<bool> setLastName(String value) async => await _prefs.setString("lastName", value);
  static Future<bool> setEmail(String value) async => await _prefs.setString("emailId", value);
  static Future<bool> setProfileImageUrl(String value) async => await _prefs.setString("profileUrl", value);
  static Future<bool> setUserId(String value) async => await _prefs.setString("userId", value);
  static Future<bool> setToken(String value) async => await _prefs.setString("token", value);
  static Future<bool> setRole(String value) async => await _prefs.setString("role", value);

  /*static Future<bool> setClockInStatus(bool value) async => await _prefs.setBool("isClockIn", value);*/


  //gets
  static bool? getLoginStatus() => _prefs.getBool("isLogin") == null ? false : _prefs.getBool("isLogin");
  static String? getFirstName( ) => _prefs.getString("firstName") == null ? "" : _prefs.getString("firstName");
  static String? getLastName( ) => _prefs.getString("lastName") == null ? "" : _prefs.getString("lastName");
  static String? getEmail( ) => _prefs.getString("emailId") == null ? "" : _prefs.getString("emailId");
  static String? getProfileImageUrl( ) => _prefs.getString("profileUrl") == null ? "" : _prefs.getString("profileUrl");
  static String? getUserId( ) => _prefs.getString("userId") == null ? "" : _prefs.getString("userId");
  static String? getToken( ) => _prefs.getString("token") == null ? "" : _prefs.getString("token");
  static String? getRole( ) => _prefs.getString("role") == null ? "" : _prefs.getString("role");

 /* static bool? getClockInStatus( ) => _prefs.getBool("isClockIn") == null ? false : _prefs.getBool("isClockIn");*/

}
