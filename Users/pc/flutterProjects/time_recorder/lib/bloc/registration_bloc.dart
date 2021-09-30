



import 'package:rxdart/rxdart.dart';
import 'package:time_recorder/bloc/bloc.dart';
import 'package:time_recorder/network/api_client.dart';
import 'package:time_recorder/utils/validation.dart';

class RegistrationBloc extends Bloc with Validation {
  final _apiClient = ApiClient();

  final _firstName = BehaviorSubject<String>();
  Stream<String> get firstName => _firstName.stream.transform(firstNameValidate);
  void setFirstName(String value) => _firstName.sink.add(value);

  final _lastName = BehaviorSubject<String>();
  Stream<String> get lastName => _lastName.stream.transform(lastNameValidate);
  void setLastName(String value) => _lastName.sink.add(value);

  final _email = BehaviorSubject<String>();
  Stream<String> get email => _email.stream.transform(eMailValidate);
  void setEmail(String value) => _email.sink.add(value);

  final _password = BehaviorSubject<String>();
  Stream<String> get password => _password.stream.transform(passwordValidate);
  void setPassword(String value) => _password.sink.add(value);



  void submitForm(String json) {
    _apiClient.getRegister(json);
  }


  @override
  void dispose() {
    _firstName.close();
    _lastName.close();
    _email.close();
    _password.close();
  }


}