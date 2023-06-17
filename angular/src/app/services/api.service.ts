import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Human } from '../models/Human';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl:string = 'http://localhost:8080/human';
  constructor(private http:HttpClient) { }

  postRegistration(register:Human){
    const httpOptions = {headers: new HttpHeaders({'Content-Type':'application/json'})}

    return this.http.post<Human>(`${this.baseUrl}`+"/register",JSON.stringify(register),httpOptions);
  }

  getAllHumans(){
    return this.http.get<Human[]>(`${this.baseUrl}`);
  }

  updateHuman(register:Human,id:number){
    return this.http.put<Human>(`${this.baseUrl}/${id}`,register);
  }

  deleteRegistered(id:number){
    return this.http.delete<Human>(`${this.baseUrl}/${id}`);
  }

  getHumanById(id:number){
    return this.http.get<Human>(`${this.baseUrl}/${id}`);
  }

}
