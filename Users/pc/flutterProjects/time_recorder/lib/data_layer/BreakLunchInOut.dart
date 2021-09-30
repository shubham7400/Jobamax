
class BreakLunchInOut {

  final bool isLunchIn;
  final int totalLunchTime;
  final bool isBreakIn;
  final int totalBreakTime;

  BreakLunchInOut.fromJson(Map<String,dynamic> json)
      : isLunchIn = json['isLunchIn'],
        totalLunchTime = json['totalLunchTime'],
        isBreakIn = json['isBreakIn'],
        totalBreakTime = json['totalBreakTime'];
}
