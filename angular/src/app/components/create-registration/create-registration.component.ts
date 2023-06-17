import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-create-registration',
  templateUrl: './create-registration.component.html',
  styleUrls: ['./create-registration.component.css'],
})
export class CreateRegistrationComponent implements OnInit {
  season: string = '';
  genders: string[] = ['Male', 'Female'];
  foods: string[] = ['haricot', 'salade', 'ayimolou', 'couscous', 'fufu'];
  tasks: string[] = [
    'nettoyer',
    'balayer',
    'condiuire',
    'enseigner',
    'cuisiner',
  ];
  bmi: Number = 0;
  public registerForm!: FormGroup;
  constructor(private fb: FormBuilder,private service:ApiService,private toastr: ToastrService) {}
  ngOnInit(): void {
    this.registerForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(10)]],
      lastName: ['', [Validators.required, Validators.minLength(6)]],
      email: ['', [Validators.required, Validators.minLength(5)]],
      mobile: ['', [Validators.required, Validators.minLength(5)]],
      weigth: [
        '',
        [Validators.required,],
      ],
      height: [
        '',
        [Validators.required],
      ],
      sexe: [''],
      food: ['', [Validators.required]],
      tasks: ['', [Validators.required]],
      date: ['', [Validators.required]],
    });
    this.tasks
  }

  register() {
    console.log('hello');
    this.service.postRegistration(this.registerForm.value).subscribe(
      res =>{
        this.toastr.success("SUCESS");
      }
    );
  }


  // test() {
  //   console.log(this.registerForm.controls['firstName'].value);
  //   this.registerForm.controls['firstName'].valueChanges.subscribe((res) => {
  //     console.log(res);
  //   });
  //   console.log(this.service.getHumanById(2).subscribe((res)=>{console.log(res);
  //   }));
  // }
}
