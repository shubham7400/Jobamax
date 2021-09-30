
class ClockStatus {

  final bool isClockedIn;
  final int startTime;
  final bool isBreak;
  final bool isLunch;

  ClockStatus.fromJson(Map<String,dynamic> json)
      : isClockedIn = json['isClockedIn'],
        startTime = json['startTime'],
        isBreak = json['isBreak'],
        isLunch = json['isLunch'];
}
