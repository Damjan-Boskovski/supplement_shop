import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IManufacturerDto, ISaveManufacturerDto } from '../contracts/interfaces';

const HeaderOptions = {
  headers: new HttpHeaders({ 
  'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class BrandService {
  apiBaseUrl: string = `${environment.apiUrl}/manufacturers`;

  constructor(private http: HttpClient) {}

  getManufacturers(): Observable<Array<IManufacturerDto>> {
    return this.http.get<Array<IManufacturerDto>>(`${this.apiBaseUrl}`, HeaderOptions);
  }

  getManufacturerById(manufacturerId: number): Observable<IManufacturerDto> {
    return this.http.get<IManufacturerDto>(`${this.apiBaseUrl}/${manufacturerId}`, HeaderOptions);
  }

  deleteManufacturer(manufacturerId: number): Observable<IManufacturerDto> {
    return this.http.delete<IManufacturerDto>(`${this.apiBaseUrl}/delete/${manufacturerId}`, HeaderOptions);
  }

  updateManufacturer(manufacturerId: number, request: ISaveManufacturerDto): Observable<ISaveManufacturerDto> {
    return this.http.put<ISaveManufacturerDto>(`${this.apiBaseUrl}/edit/${manufacturerId}`, request, HeaderOptions);
  }

  createManufacturer(request: ISaveManufacturerDto): Observable<ISaveManufacturerDto> {
    return this.http.post<ISaveManufacturerDto>(`${this.apiBaseUrl}/create`, request, HeaderOptions);
  }
}