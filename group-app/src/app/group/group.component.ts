import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {GroupService} from './group.service';
import {Group} from './group';

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit{

  groups: Group[] | undefined;
  protected statusMessage: string | undefined;
  group = new Group();

  constructor(private _groupService: GroupService,
              private _router: Router){}

  ngOnInit(): void {
    this.getGroups();
  }

  getGroups(): void{
    this._groupService.getAllGroups()
      .subscribe((groupData) => this.groups = groupData,
        (error) =>{
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        }
      );

  }

  addGroup(): void{
    this._groupService.addGroup(this.group)
      .subscribe((response: any) => {console.log(response); this.getGroups();this.reset();},
        (error: any) =>{
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        }
      );
  }

  private reset(){
    this.group.id = null;
    this.group.title = null;
  }

  deleteGroup(groupId: string){
    console.log("Inside the deleteGroup()::::Group id::::"+groupId);
    this._groupService.deleteGroup(groupId)
      .subscribe((response: any) => {console.log(response); this.getGroups();},
        (error: any) =>{
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        });
    this.reset();
    console.log("end of deleteBook():::::::");
  }

  getGroup(groupId: string){
    this._groupService.getGroupById(groupId)
      .subscribe((groupData) => {this.group = groupData; this.getGroups(); }),
      (error: any) => {
        console.log(error);
        this.statusMessage = "Problem with service. Please try again later!";
      }
    this.reset();
  }
}
