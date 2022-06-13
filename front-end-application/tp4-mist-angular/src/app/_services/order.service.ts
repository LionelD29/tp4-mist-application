import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order, OrderForm } from '../_models/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private BASE_URL: string = 'http://localhost:8080/orders';

  constructor(private http: HttpClient) { }

  public placeOrder(form: OrderForm): Observable<Order> {
    return this.http.post<Order>(`${this.BASE_URL}/add`, form);
  }

  public getOrdersByUser(): Observable<Array<Order>> {
    return this.http.get<Array<Order>>(`${this.BASE_URL}`);
  }

  public getOneUserOrderByOrderId(orderId: number): Observable<Order> {
    return this.http.get<Order>(`${this.BASE_URL}/${orderId}`);
  }

  public deleteUserOrderById(orderId: number): Observable<Order> {
    return this.http.delete<Order>(`${this.BASE_URL}/${orderId}`);
  }
  
}
