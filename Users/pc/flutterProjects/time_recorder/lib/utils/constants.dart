
    import 'package:time_recorder/ui/supervisor_screens/supervisor_task.dart';

final phoneRegExp = RegExp(r"^\+?0[0-9]{10}$");
    final emailRegExp = RegExp(r"^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\.[a-zA-Z]+");
    final passwordRegExp = new RegExp(r'^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#\$&*~]).{8,}$');
    final nameRegExp = new RegExp(r"^\s*([A-Za-z]{1,}([\.,] |[-']| ))+[A-Za-z]+\.?\s*$");


 const String SIGNUP = "signup";
 const String LOGIN = "login";
 const String UPDATE_USER_PROFILE = "updateUserProfile";
 const String CREATE_TASK = "createTask";
 const String GET_DIRECT_TASK = "getDirectTask";
 const String GET_INDIRECT_TASK = "getInDirectTask";
 const String GET_TASK_LOGS = "getTaskLogs";
 const String GET_SHIFT_TIME = "getShiftTiming";
 const String FORGOT_PASS  = "forgotPassword";
 const String VERIFY_OTP = "verifyOtp";
 const String RESET_PASSWORD = "resetPassword";
 const String START_STOP_TASK = "startAndStopTask";
 const String UPDATE_TASK = "updateTask";
 const String CLOCK_TIME_STATUS = "getClockTimeStatus";
 const String TOTAL_TIME = "getTotalTime";
 const String SAVE_BREAK_TIME = "saveBreakTime";