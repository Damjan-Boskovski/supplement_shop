import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CommService {
  constructor() {}

  subject = new Subject();

  deliver(item: object) {
    this.subject.next(item);
  }

  recieve() {
    return this.subject.asObservable();
  }
}