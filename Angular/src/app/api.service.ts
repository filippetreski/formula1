import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Driver} from './dto/Driver';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) {
  }

  getFOneAbstract(language: string): Observable<object> {
    return this.httpClient.get<object>(`/api/formula_one/abstract/${language}`);
  }

  getListOfDrivers(language: string, limit: number): Observable<Array<Driver>> {
    return this.httpClient.get<Array<Driver>>(`/api/formula_one/drivers/list/${limit}/${language}`);
  }

  searchDrivers(searchTerm: string, language: string, limit: number): Observable<Array<Driver>> {
    return this.httpClient.get<Array<Driver>>(`/api/formula_one/drivers/search/${searchTerm}/${limit}/${language}`);
  }

  getDriverDetails(name: string, language: string): Observable<object> {
    return this.httpClient.get<object>(`/api/formula_one/drivers/details/basic/${name}/${language}`);
  }
}
