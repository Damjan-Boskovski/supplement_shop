import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ICategoryDto } from '../contracts/interfaces';

const HeaderOptions = {
  headers: new HttpHeaders({ 
  'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  apiBaseUrl: string = `${environment.apiUrl}/categories`;

  constructor(private http: HttpClient) {}

  getCategories(): Observable<Array<ICategoryDto>> {
    return this.http.get<Array<ICategoryDto>>(`${this.apiBaseUrl}`, HeaderOptions);
  }

  getCategoryById(categoryId: number): Observable<ICategoryDto> {
    return this.http.get<ICategoryDto>(`${this.apiBaseUrl}/${categoryId}`, HeaderOptions);
  }
}