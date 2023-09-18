import { Injectable } from '@angular/core';
import { HttpClient,HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CompanyDto } from '../model/company-dto';
import { TitleStrategy } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  addEmployeeURL : string;
getEmployeeURL : string;
updateEmployeeURL :string;
deleteEmployeeURL : string;
  constructor(private http:HttpClient) { 
    this.addEmployeeURL='http://localhost:8080/employee/employeeRegistration';
    this.getEmployeeURL='http://localhost:8080/employee/company/0/100/id' ;
    //this.getEmployeeURL='http://localhost:8080/employee/allemployeeDetails' ;
    this.updateEmployeeURL='http://localhost:8080/employee/updateEmployee';
    this.deleteEmployeeURL='http://localhost:8080/employee';
}


addEmployee(emp:CompanyDto):Observable<CompanyDto>{
return this.http.post<CompanyDto>(this.addEmployeeURL,emp);
}


getAllEmployee():Observable<CompanyDto[]>{
//return this.http.get<CompanyDto[]>(this.getEmployeeURL);
return this.http.get<CompanyDto[]>(this.getEmployeeURL);

}

updateEmployee(emp:CompanyDto):Observable<CompanyDto>{
  return this.http.put<CompanyDto>(this.updateEmployeeURL+'/'+emp.id,emp);
}

deleteEmployee(emp:CompanyDto):Observable<CompanyDto>{
 
  return this.http.delete<CompanyDto>(this.deleteEmployeeURL+'/'+emp.id);
}


}
