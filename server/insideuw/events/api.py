from django_filters.rest_framework import DjangoFilterBackend

from rest_framework.filters import SearchFilter, OrderingFilter
from rest_framework.serializers import ModelSerializer
from rest_framework.viewsets import ModelViewSet


from .models import Event


class EventsSerializer(ModelSerializer):
    # def get_image(self, event):
    #     request = self.context.get('request')
    #     image_url = event.image.url
    #     return request.build_absolute_uri(image_url)

    class Meta:
        model = Event
        fields = ('name', 'organizer', 'city', 'date', 'address', 'image', 'url')


class EventViewSet(ModelViewSet):
    queryset = Event.objects.all()

    serializer_class = EventsSerializer

    filter_backends = (DjangoFilterBackend, SearchFilter, OrderingFilter)

    filter_fields = ('organizer', 'city', 'date', 'address')

    search_fields = ('name', 'address')
