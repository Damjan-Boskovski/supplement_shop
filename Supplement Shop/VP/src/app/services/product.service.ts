import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IProductDto, ISaveProductDto } from '../contracts/interfaces';

const HeaderOptions = {
  headers: new HttpHeaders({ 
  'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  apiBaseUrl: string = `${environment.apiUrl}/products`;

  constructor(private http: HttpClient) {}

  getProducts(): Observable<Array<IProductDto>> {
    return this.http.get<Array<IProductDto>>(`${this.apiBaseUrl}`, HeaderOptions);
  }

  getProductById(productId: number): Observable<IProductDto> {
    return this.http.get<IProductDto>(`${this.apiBaseUrl}/${productId}`, HeaderOptions);
  }

  deleteProduct(productId: number): Observable<IProductDto> {
    return this.http.delete<IProductDto>(`${this.apiBaseUrl}/delete/${productId}`, HeaderOptions);
  }

  updateProduct(productId: number, request: ISaveProductDto): Observable<ISaveProductDto> {
    return this.http.put<ISaveProductDto>(`${this.apiBaseUrl}/edit/${productId}`, request, HeaderOptions);
  }

  createProduct(request: ISaveProductDto): Observable<ISaveProductDto> {
    return this.http.post<ISaveProductDto>(`${this.apiBaseUrl}/create`, request, HeaderOptions);
  }
}