import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/index';

/**
 * Class representing application service.
 *
 * @class AppService.
 */
@Injectable()
export class AppService {
  private serviceUrl = '/api/summary';
  private dataPostTestUrl = '/api/postTest';

  constructor(private http: HttpClient) {
  }

  /**
   * Makes a http get request to retrieve the welcome message from the backend service.
   */
  public getWelcomeMessage() {
    return this.http.get(this.serviceUrl).pipe(
      map(response => response)
    );
  }

  /**
   * Makes a http post request to send some data to backend & get response.
   */
  public sendData(): Observable<any> {
    return this.http.post(this.dataPostTestUrl, {});
  }
  getBeer() {
    return this.http.get('http://localhost:4200/api/ok')
  }
  getBeer1() {
    return this.http.get('http://localhost:4200/api/ok1')
  }
  getBeer2() {
    return this.http.get('http://localhost:4200/api/ok2')
  }
  getBeer3() {
    return this.http.get('http://localhost:4200/api/ok4')
  }
  getBeer4() {
    return this.http.get('http://localhost:4200/api/ok5')
  }
  getBeer5(day: string,month:string,year:string) {
    return this.http.get('http://localhost:4200/api/ok3'+'/'+day+'/'+month+'/'+year)
  }
}
