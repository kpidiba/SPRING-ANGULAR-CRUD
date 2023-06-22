import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateRegistrationComponent } from './components/create-registration/create-registration.component';
import { RegistrationListComponent } from './components/registration-list/registration-list.component';

const routes: Routes = [
  {path:'',redirectTo:'register',pathMatch:'full'},
  {path:'register',component:CreateRegistrationComponent},
  {path:'update/:id',component:CreateRegistrationComponent},
  {path:'list',component:RegistrationListComponent,},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
