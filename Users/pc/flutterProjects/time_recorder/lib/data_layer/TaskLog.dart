
class TaskLog {

  final bool isActive;
  final int startTime;
  final double time;
  final String title;
  final double endtime;

  TaskLog.fromJson(Map<String,dynamic> json)
      : isActive = json['isActive'],
        startTime = json['startTime'],
        time = double.parse( json['time'].toString()),
        title = json['title'],
        endtime = double.parse( json['endtime'].toString());
}
