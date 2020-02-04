import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
private baseUrl='';

  constructor(private http:HttpClient) {

  }
    getProfile(id: number):Observable<any>{
    return this.http.get('$(this.baseUrl)/$(id)');
    }
}
