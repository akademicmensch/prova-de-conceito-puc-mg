import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA} from '@angular/material/dialog';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-modal-descricao',
  templateUrl: './modal-descricao.component.html',
  styleUrls: ['./modal-descricao.component.css']
})
export class ModalDescricaoComponent implements OnInit {

  constructor(

    private dialogRef:  MatDialogRef<ModalDescricaoComponent>,
    @Inject(MAT_DIALOG_DATA) data
  ) { 
    this.desc = data.desc
    this.desc2 = data.desc2
  }

  desc = ""
  desc2 = ""

  ngOnInit(): void {
  }

  close(){
    this.dialogRef.close(this.desc)
  }

}
