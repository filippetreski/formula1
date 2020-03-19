import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) { }

  getFOneAbstract(language: String): Observable<Object>{
    return this.httpClient.get<Object>(`/api/formula_one/abstract/${language}`);
  }

}
