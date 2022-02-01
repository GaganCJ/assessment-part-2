export class RESTAPIService {

  useRepo = 'http://localhost:7091';
  assRepo = 'http://localhost:7092';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  findRegisters(): Observable<Assreg[]> {
    return this.http.get<Assreg[]>(this.assRepo + '/findAllReg')
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  postRegDetails(regDetail): Observable<Assreg> {
    return this.http.post<Assreg>(this.assRepo + '/regOne', JSON.stringify(regDetail), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  loginFunc(user): Observable<Users> {
    return this.http.post<Users>(this.useRepo + '/getUserValid', JSON.stringify(user), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  getUserId(): Observable<number> {
    return this.http.get<number>(this.useRepo + '/userId')
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  logoutSignal(): Observable<any> {
    return this.http.get<any>(this.useRepo + '/logout')
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return errorMessage;
  }
}
