import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  imgSrc!:string;

  constructor() { }

  ngOnInit() {
    this.imgSrc = "assets\\images\\logo.png";
  }

}
