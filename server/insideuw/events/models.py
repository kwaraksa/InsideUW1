from django.db import models
from django.contrib.auth.models import User

from .managers import EventManager


class Event(models.Model):
    name = models.CharField('Nazwa', max_length=100)
    organizer = models.CharField('Organizator', max_length=100)
    city = models.CharField('Miasto', max_length=100)
    date = models.DateTimeField('Data')
    address = models.CharField('Miejsce', max_length=100)
    image = models.ImageField('Zdjęcie', upload_to='media')
    url = models.URLField('Link do zapisów', max_length=100, blank=True, default='')

    objects = EventManager()
