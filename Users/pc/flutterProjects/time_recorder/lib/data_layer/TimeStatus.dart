
class TimeStatus {

  final double totalTime;
  final double totalClockTime;
  final double totalBreakTime;
  final double totalLunchTime;

  TimeStatus.fromJson(Map<String,dynamic> json)
      : totalTime = json['totalTime'],
        totalClockTime = json['totalClockTime'],
        totalBreakTime = double.parse(json['totalBreakTime'].toString()),
        totalLunchTime = double.parse(json['totalLunchTime'].toString());
}
