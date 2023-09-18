import { Component,OnInit } from '@angular/core';
import {FormBuilder, FormGroup,FormControl} from '@angular/forms'
import { CompanyDto } from '../model/company-dto';
import { CompanyService } from '../service/company.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  employee !: FormGroup
  
  employeeObj : CompanyDto=new CompanyDto();
employeelist : CompanyDto[]=[];

  

constructor(private formbuilder:FormBuilder, private empService:CompanyService) { }

  ngOnInit(): void {

    this.getAllEmployee();

    this.employee = this.formbuilder.group({
      id :[" "],
     employeeId:[" "],
      firstName : [" "],
      middleName : [" "],
      lastName : [" "],
      password : [" "]
    });
  }          
  

  addEmployee() {
    console.log(this.employee);
    this.employeeObj.id=this.employee.value.id;
    this.employeeObj.employeeId=this.employee.value.employeeId;
    this.employeeObj.firstName=this.employee.value.firstName;
    this.employeeObj.middleName=this.employee.value.middleName;
    this.employeeObj.lastName=this.employee.value.lastName;
    this.employeeObj.password=this.employee.value.password;

  
    this.empService.addEmployee(this.employeeObj).subscribe(result=>{
   console.log(result);
   this.getAllEmployee();
   },err=>{
  console.log(err);
  })
  }


 getAllEmployee(){
this.empService.getAllEmployee().subscribe(result=>{
  this.employeelist=result;
},err=>{
  console.log(err);
});
}



editEmployee(emp:CompanyDto){
this.employee.controls['id'].setValue(emp.id);
this.employee.controls['employeeId'].setValue(emp.employeeId);
this.employee.controls['firstName'].setValue(emp.firstName);
this.employee.controls['middleName'].setValue(emp.middleName);
this.employee.controls['lastName'].setValue(emp.lastName);
this.employee.controls['password'].setValue(emp.password);

}


updateEmployee(){
  this.employeeObj.id=this.employee.value.id;
  this.employeeObj.employeeId=this.employee.value.employeeId;
    this.employeeObj.firstName=this.employee.value.firstName;
    this.employeeObj.middleName=this.employee.value.middleName;
    this.employeeObj.lastName=this.employee.value.lastName;
    this.employeeObj.password=this.employee.value.password;
   

  this.empService.updateEmployee(this.employeeObj).subscribe(result=>{
    console.log(result);
    this.getAllEmployee();
    },err=>{
console.log(err)
    });
}


deleteEmployee(emp:CompanyDto){
  this.empService.deleteEmployee(emp).subscribe(result=>{
    console.log("result="+result);
    alert("Delete Sucessfully");
    this.getAllEmployee();
  },err=>{
    console.log(err);
  });
  alert("Data Delete Sucessfully");
  }



  
}


  

