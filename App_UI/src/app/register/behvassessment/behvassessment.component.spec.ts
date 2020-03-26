import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BehvassessmentComponent } from './behvassessment.component';

describe('BehvassessmentComponent', () => {
  let component: BehvassessmentComponent;
  let fixture: ComponentFixture<BehvassessmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BehvassessmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BehvassessmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
