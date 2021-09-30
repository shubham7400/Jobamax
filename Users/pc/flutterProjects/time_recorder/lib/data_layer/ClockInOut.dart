
class ClockInOut {

  final bool isClockedIn;
  final int clockInTime;

  ClockInOut.fromJson(Map<String,dynamic> json)
      : isClockedIn = json['isClockedIn'],
        clockInTime = json['clockInTime'];
}
