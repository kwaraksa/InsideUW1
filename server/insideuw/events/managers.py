from django.db.models import Manager

from .queryset import EventQuerySet


class EventBaseManager(Manager):
    pass


EventManager = EventBaseManager.from_queryset(EventQuerySet)
