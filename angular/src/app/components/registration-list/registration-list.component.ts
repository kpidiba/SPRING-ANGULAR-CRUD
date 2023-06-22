import { Component, ViewChild, OnInit } from '@angular/core';
import { MatSort } from '@angular/material/sort'
import { MatTableDataSource } from '@angular/material/table'
import { MatPaginator } from '@angular/material/paginator'
import { Human } from 'src/app/models/Human';
import { ApiService } from 'src/app/services/api.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-registration-list',
  templateUrl: './registration-list.component.html',
  styleUrls: ['./registration-list.component.css']
})
export class RegistrationListComponent implements OnInit {
  public dataSource!: MatTableDataSource<Human>;
  public humans!: Human[];
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  displayedColumns: string[] = ['firstName', 'lastName', 'email', 'weigth', 'heigth', 'sexe', 'food', 'action' ,/**  'tasks', 'date' */];
  constructor(private api: ApiService, private route: Router) {

  }
  ngOnInit(): void {
    this.getHumans();
  }

  getHumans() {
    this.api.getAllHumans().subscribe(res => {
      this.humans = res;
      console.log(res);

      this.dataSource = new MatTableDataSource(this.humans);
      this.dataSource.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  edit(id: number) {
    this.route.navigate(['update', id]);
  }

  delete(id:number){
    console.log(id);
  }
}
