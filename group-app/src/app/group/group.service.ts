import { Injectable } from '@angular/core';
// @ts-ignore
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Group } from './group';

@Injectable()
export class GroupService{

  constructor(private _httpService: Http){}

  getAllGroups(): Observable<Group[]>{
    return this._httpService.get("http://localhost:8037/spring-mvc-restfull-crud-example/group")
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }

  getGroupById(bookId: string): Observable<Group>{
    return this._httpService.get("http://localhost:8037/spring-mvc-restfull-crud-example/book/"+bookId)
      .map((response: Response) => response.json())
      .catch(this.handleError);
  }

  addGroup(group: Group){
    let body = JSON.parse(JSON.stringify(group));
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    if(group.id){
      return this._httpService.put("http://localhost:8037/spring-mvc-restfull-crud-example/group/"+group.id, body, options);
    }else{
      return this._httpService.post("http://localhost:8037/spring-mvc-restfull-crud-example/group", body, options);
    }
  }

  deleteGroup(groupId: string){
    return this._httpService.delete("http://localhost:8037/spring-mvc-restfull-crud-example/group/"+groupId);
  }

  private handleError(error: Response){
    return Observable.throw(error);
  }
}
