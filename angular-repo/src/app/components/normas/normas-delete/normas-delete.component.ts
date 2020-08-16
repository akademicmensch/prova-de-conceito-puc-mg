import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { Norma } from '../norma.model';
import { NormaService } from '../norma.service';

@Component({
  selector: 'app-normas-delete',
  templateUrl: './normas-delete.component.html',
  styleUrls: ['./normas-delete.component.css']
})
export class NormasDeleteComponent implements OnInit {
  
  norma: Norma;

  constructor(
    private normaService: NormaService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.normaService.readById(id).subscribe((norma) => {
      this.norma = norma;
    });
  }

  deleteNorma(): void {
    this.normaService.deleteNorma(this.norma.id).subscribe(() => {
      //this.normaService.showMessage("Produto excluido com sucesso!");
      this.router.navigate(["/normas"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/normas"]);
  }

}
