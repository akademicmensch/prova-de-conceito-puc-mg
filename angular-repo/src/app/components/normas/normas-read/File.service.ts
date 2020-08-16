import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { HttpClient } from "@angular/common/http";
import { Observable, EMPTY } from "rxjs";
import { map, catchError } from "rxjs/operators";


@Injectable({
    providedIn: "root",
  })
  export class FileService {

    constructor(private snackBar: MatSnackBar, private http: HttpClient) {}

    baseUrl = "http://localhost:8092/normas/v1";

    upload(file: FormData, id): Observable<File> {
        
        const url = `${this.baseUrl}/${id}/pdf`
    
        return this.http.post<File>(url, file)
    
          .pipe(

    
          )
        }   

}   