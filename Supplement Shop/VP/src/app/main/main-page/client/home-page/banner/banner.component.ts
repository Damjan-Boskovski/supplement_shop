import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss']
})
export class BannerComponent implements OnInit {

  imgBanner: string = "assets\\images\\h1.png";

  constructor() { }

  ngOnInit() {
  }

  onChange()
  {
    if (this.imgBanner == "assets\\images\\h1.png")
      this.imgBanner = "assets\\images\\h11.png";
    else
    this.imgBanner = "assets\\images\\h1.png";
  }
}
