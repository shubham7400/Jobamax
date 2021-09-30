
class Shift {

  final String shiftId;
  final String clockInTime;
  final String clockOutTime;
  final String lunchTime;
  final String teaTime;
  final String shiftName;
  final String createDate;

  Shift.fromJson(Map<String,dynamic> json)
      : shiftId = json['shiftId'],
        clockInTime = json['clockInTime'],
        clockOutTime = json['clockOutTime'],
        lunchTime = json['lunchTime'],
        teaTime = json['teaTime'],
        shiftName = json['shiftName'],
        createDate = json['createDate'];
}
