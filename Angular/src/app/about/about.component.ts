import {Component, OnInit} from '@angular/core';
import {ApiService} from '../api.service';
import {ActivatedRoute, Router} from '@angular/router';
import {switchMap} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  abstract: string;

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

    this.route.queryParamMap.pipe(
      switchMap(result => {
        if (!result || !result.get('language')) {
          return new Observable();
        } else {
          return this.api.getFOneAbstract(result.get('language'));
        }
      })
    ).subscribe(result => {
      if (result && result[0] && result[0].abstract) {
        this.abstract = result[0].abstract.value;
      }
    });
  }

}
