import {Component, OnInit} from '@angular/core';
import {ApiService} from '../api.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private api: ApiService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.route.queryParamMap.subscribe(it => {
      if (!it || !it.get('language')) {
        this.router.navigate([], {
          queryParams: {language: 'en'},
          relativeTo: this.route,
          queryParamsHandling: 'merge'
        });
      }
    });
  }

}
