import { Component, OnInit,Input} from '@angular/core';
import {Profile} from '../profile';
import {ProfileService} from '../profile.service';
import {Router,ActivatedRoute} from '@angular/router';



@Component({
  selector: 'app-profile-details',
  templateUrl: './profile-details.component.html',
  styleUrls: ['./profile-details.component.css']
})
export class ProfileDetailsComponent implements OnInit {

id:number;
profile:Profile; 

  constructor(private route:ActivatedRoute,private profileService: ProfileService) { }

  ngOnInit() {
  this.profile = new Profile();
  this.id=this.route.snapshot.params['id'];
  this.profileService.getProfile(this.id)
    .subscribe(data => {
      console.log(data)
      this.profile=data;
    }, error => console.log(error));         
  }

}
