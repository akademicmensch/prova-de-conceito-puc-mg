import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { Router, ActivatedRoute } from "@angular/router";
import { ProcessosService } from '../processos-read/processos.service';
@Component({
  selector: 'app-dialog-element-processo',
  templateUrl: './dialog-element-processo.component.html',
  styleUrls: ['./dialog-element-processo.component.css']
})
export class DialogElementProcessoComponent implements OnInit{
  constructor(public dialog: MatDialog, private router: Router, private route: ActivatedRoute, private processosService:ProcessosService) {}


  id:string;
  apiUrl:string = "http://3.15.185.169:8989/industrialProcess/v1/";
  apiUrl2:string;
  

  ngOnInit(): void {
    const ida = this.route.snapshot.paramMap.get("id");
    console.log('----------------------------------------------------')
    console.log(ida)
    console.log('----------------------------------------------------')
    
    this.id = ida.toString();
    console.log(this.id);

    const newLocal = this.processosService.readProcess(this.id);

    this.dialog.open(DialogElementProcessoComponent)

  }

  openDialog(param:string) {

  }

}