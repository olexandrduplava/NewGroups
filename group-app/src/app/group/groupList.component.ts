import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { GroupService } from './group.service';
import { Group } from './group';
import { Router } from '@angular/router';


@Component({
  selector: 'group-list',
  templateUrl: './groupList.component.html',
  styleUrls: ['./groupList.component.css']
})
export class GroupListComponent implements OnInit{
  group = new Group();
  statusMessage: string | undefined;
  groups: Group[] | undefined;
  constructor(private _bookService: GroupService,
              private _router: Router){}

  ngOnInit(): void {
    console.log("calling ngOnInit()::::");
    this.getGroups();
  }

  getGroups(): void{
    console.log("Inside getGroups():::::")
    this._bookService.getAllGroups()
      .subscribe((groupData) => this.groups = groupData,
        (error) =>{
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        }
      );
    console.log("end of getGroups():::::");
  }
}
