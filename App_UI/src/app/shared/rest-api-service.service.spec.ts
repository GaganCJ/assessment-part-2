import { TestBed } from '@angular/core/testing';

import { RESTAPISERVICEService } from './rest-api-service.service';

describe('RESTAPISERVICEService', () => {
  let service: RESTAPISERVICEService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RESTAPISERVICEService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
